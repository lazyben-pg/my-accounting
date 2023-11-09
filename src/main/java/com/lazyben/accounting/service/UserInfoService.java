package com.lazyben.accounting.service;

import com.lazyben.accounting.converter.btv.UserInfoBTVConverter;
import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import com.lazyben.accounting.model.dataobject.UserInfoDO;
import com.lazyben.accounting.model.viewobject.UserInfoVO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    private final UserInfoDao userInfoDao;
    private final UserInfoBTVConverter userInfoBTVConverter;

    @Autowired
    public UserInfoService(UserInfoDao userInfoDao, UserInfoBTVConverter userInfoBTVConverter) {
        this.userInfoDao = userInfoDao;
        this.userInfoBTVConverter = userInfoBTVConverter;
    }

    public UserInfoVO getUserById(long id) {
        val userInfo = userInfoDao.getUserById(id);
        return userInfoBTVConverter.convert(userInfo);
    }
}
