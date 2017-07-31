package cn.kxind.mybatis.dao;

import cn.kxind.mybatis.bean.AuthRoleFunction;

public interface AuthRoleFunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthRoleFunction record);

    int insertSelective(AuthRoleFunction record);

    AuthRoleFunction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthRoleFunction record);

    int updateByPrimaryKey(AuthRoleFunction record);
}