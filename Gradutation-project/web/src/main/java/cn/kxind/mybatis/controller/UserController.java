package cn.kxind.mybatis.controller;

import cn.kxind.mybatis.bean.User;
import cn.kxind.mybatis.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/28.
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 登录界面
     *
     * @return
     */
    @PostMapping("/ajaxLogin")
    public String ajaxLogin(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name + "----" + pwd);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return "login";
        }
        return "layouts";
    }

    /**
     * 注册
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/ajaxRegister")
    @ResponseBody
    public boolean ajaxRegister(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
        String createTime = df.format(new Date());
        User user = new User();
        user.setCreatedate(createTime);
        user.setName(name);
        user.setPwd(pwd);
        user.setStatus(0);//0代表激活
        int status = userService.insert(user);
        if (status == 1) {
            return true;
        } else {
            return false;
        }
    }

}
