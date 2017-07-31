package cn.kxind.mybatis.dao;

import cn.kxind.mybatis.bean.AuthFunction;

public interface AuthFunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthFunction record);

    int insertSelective(AuthFunction record);

    AuthFunction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthFunction record);

    int updateByPrimaryKey(AuthFunction record);
}