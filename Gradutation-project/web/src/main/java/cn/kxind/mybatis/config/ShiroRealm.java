package cn.kxind.mybatis.config;

import cn.kxind.mybatis.bean.AuthFunction;
import cn.kxind.mybatis.bean.AuthRole;
import cn.kxind.mybatis.bean.User;
import cn.kxind.mybatis.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/27.
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return 给某个user 分配权限
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        User token = (User)SecurityUtils.getSubject().getPrincipal();
        Long userId = token.getId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        List<AuthRole> list=userService.selectRoleById(userId.intValue());
        Set<String> roleSet = new HashSet<String>();
        for (AuthRole role:list
             ) {
            roleSet.add(role.getName());//只有admin才有权限
        }
        info.setRoles(roleSet);
        //设置用户session
        Set<String> permissionSet = new HashSet<String>();
        List<AuthFunction> functionList=userService.selectFcuntionById(list.get(0).getId().intValue());

        for (AuthFunction f:functionList
             ) {
            permissionSet.add(f.getName());
        }
        info.setStringPermissions(permissionSet);
        return info;    }

    /***
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进入验证用户身份");
        String userName = (String)token.getPrincipal();  //得到用户名
        String pwd = new String((char[])token.getCredentials()); //得到密码
       User user=userService.ajaxLogin(userName,pwd);//通过账号获取user对象 比较密码
        List<AuthRole> role=userService.selectRoleById(user.getId().intValue());
        System.out.println(userName+"---"+pwd);
        if (user!=null) {
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", role.get(0));
            return new SimpleAuthenticationInfo(user,pwd,getName());
        } else {
            return null;
      }


    }
}
