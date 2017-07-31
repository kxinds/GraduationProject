package cn.kxind.mybatis.dao;

import cn.kxind.mybatis.bean.AuthUserRole;

public interface AuthUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

    AuthUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthUserRole record);

    int updateByPrimaryKey(AuthUserRole record);
}