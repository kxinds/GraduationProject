package cn.kxind.mybatis.service;

import cn.kxind.mybatis.bean.AuthFunction;
import cn.kxind.mybatis.bean.AuthRole;
import cn.kxind.mybatis.bean.User;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/28.
 */
public interface IUserService {
    /**
     * 登录
     * @param name
     * @param pwd
     * @return
     */
    public User ajaxLogin(String name,String pwd);

    /**
     * 注册
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 根据id获取角色
     * @param id
     * @return
     */
    public List<AuthRole>  selectRoleById(int id);

    /**
     * 根据角色id加载相应的功能
     * @param id
     * @return
     */
    public List<AuthFunction>  selectFcuntionById(int id);

}
