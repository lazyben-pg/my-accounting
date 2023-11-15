package com.lazyben.accounting.service;

import com.lazyben.accounting.converter.dtb.UserInfoDTBConverter;
import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao userInfoDao;
    private final UserInfoDTBConverter userInfoDTBConverter;

    @Autowired
    public UserInfoServiceImpl(UserInfoDao userInfoDao, UserInfoDTBConverter userInfoDTBConverter) {
        this.userInfoDao = userInfoDao;
        this.userInfoDTBConverter = userInfoDTBConverter;
    }

    @Override
    public UserInfoBO getUserById(long id) {
        val userInfo = userInfoDao.getUserById(id);
        return userInfoDTBConverter.convert(userInfo);
    }
}
