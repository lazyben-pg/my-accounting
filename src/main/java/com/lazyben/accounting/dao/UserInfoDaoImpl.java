package com.lazyben.accounting.dao;

import com.lazyben.accounting.converter.dtb.UserInfoDTBConverter;
import com.lazyben.accounting.dao.mapper.UserInfoDOMapper;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDao {
    private final UserInfoDOMapper userInfoDOMapper;
    private final UserInfoDTBConverter userInfoDTBConverter;

    @Autowired
    public UserInfoDao(UserInfoDOMapper userInfoDOMapper, UserInfoDTBConverter userInfoDTBConverter) {
        this.userInfoDOMapper = userInfoDOMapper;
        this.userInfoDTBConverter = userInfoDTBConverter;
    }

    public UserInfoBO getUserById(long id) {
        val userInfo = userInfoDOMapper.selectByPrimaryKey(id);
        return userInfoDTBConverter.convert(userInfo);
    }
}
