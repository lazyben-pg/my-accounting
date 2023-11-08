package com.lazyben.accounting.dao;

import com.lazyben.accounting.mapper.UserInfoMapper;
import com.lazyben.accounting.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDao {
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoDao(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfo getUserById(long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
