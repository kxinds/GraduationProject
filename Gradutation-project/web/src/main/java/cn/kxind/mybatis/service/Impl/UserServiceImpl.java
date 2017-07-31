package cn.kxind.mybatis.service.Impl;

import cn.kxind.mybatis.bean.AuthFunction;
import cn.kxind.mybatis.bean.AuthRole;
import cn.kxind.mybatis.bean.User;
import cn.kxind.mybatis.dao.UserMapper;
import cn.kxind.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/28.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User ajaxLogin(String name, String pwd) {

        return userMapper.selectPassword(name, pwd);
    }

    @Override
    public int insert(User user) {
        User usercompare = userMapper.selectName(user.getName());
        if(usercompare!=null){
            return 0;
        }

        return userMapper.insertSelective(user);
    }

    @Override
    public List<AuthRole> selectRoleById(int id) {

        return userMapper.selectRoleById(id);
    }

    @Override
    public List<AuthFunction> selectFcuntionById(int id) {

        return userMapper.selectFunctionById(id);
    }
}
