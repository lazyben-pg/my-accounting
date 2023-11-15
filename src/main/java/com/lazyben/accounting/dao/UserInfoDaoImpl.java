package com.lazyben.accounting.dao;

import com.lazyben.accounting.dao.mapper.UserInfoDOMapper;
import com.lazyben.accounting.model.dataobject.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    private final UserInfoDOMapper userInfoDOMapper;

    @Autowired
    public UserInfoDaoImpl(UserInfoDOMapper userInfoDOMapper) {
        this.userInfoDOMapper = userInfoDOMapper;
    }

    @Override
    public UserInfoDO getUserById(long id) {
        return userInfoDOMapper.selectByPrimaryKey(id);
    }
}
