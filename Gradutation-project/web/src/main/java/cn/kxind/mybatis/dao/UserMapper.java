package cn.kxind.mybatis.dao;

import cn.kxind.mybatis.bean.AuthFunction;
import cn.kxind.mybatis.bean.AuthRole;
import cn.kxind.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登录验证
     * @param name 账号
     * @param pwd  密码
     * @return
     */
    User selectPassword(@Param("name")String name, @Param("pwd")String pwd);

    /**
     * 注册验证
     * @param name 账号
     * @return
     */
    User selectName(@Param("name")String name);

    /**
     * 通过useid查询角色集合
     * @param id
     * @return
     */
     List<AuthRole> selectRoleById(@Param("id")int id);

    /**
     * 通过useid获取
     * @param id
     * @return
     */
    List<AuthFunction> selectFunctionById(@Param("id")int id);
}