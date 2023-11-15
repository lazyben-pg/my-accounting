package com.lazyben.accounting.dao;

import com.lazyben.accounting.model.dataobject.UserInfoDO;

public interface UserInfoDao {
    UserInfoDO getUserById(long id);
}
