package com.lazyben.accounting.service;

import com.lazyben.accounting.model.businessobject.UserInfoBO;

public interface UserInfoService {
    UserInfoBO getUserById(long id);
}
