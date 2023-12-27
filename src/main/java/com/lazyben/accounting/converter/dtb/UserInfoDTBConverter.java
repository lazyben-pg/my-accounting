package com.lazyben.accounting.converter.dtb;

import com.google.common.base.Converter;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import com.lazyben.accounting.model.dataobject.UserInfoDO;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDTBConverter extends Converter<UserInfoDO, UserInfoBO> {
    @Override
    protected UserInfoBO doForward(UserInfoDO userInfoDO) {
        return UserInfoBO.builder()
                         .id(userInfoDO.getId())
                         .username(userInfoDO.getUsername())
                         .password(userInfoDO.getPassword())
                         .build();
    }

    @Override
    protected UserInfoDO doBackward(UserInfoBO userInfoBO) {
        throw new UnsupportedOperationException("Can not convert UserInfo business object to UserInfo data object");
    }
}
