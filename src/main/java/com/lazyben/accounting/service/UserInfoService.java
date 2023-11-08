package com.lazyben.accounting.service;

import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    private final UserInfoDao userInfoDao;

    @Autowired
    public UserInfoService(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public UserInfo getUserById(long id) {
        return userInfoDao.getUserById(id);
    }
}
