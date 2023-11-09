package com.lazyben.accounting.converter.btv;

import com.google.common.base.Converter;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import com.lazyben.accounting.model.viewobject.UserInfoVO;
import org.springframework.stereotype.Component;

@Component
public class UserInfoBTVConverter extends Converter<UserInfoBO, UserInfoVO> {

    @Override
    protected UserInfoVO doForward(UserInfoBO userInfoBO) {
        return UserInfoVO.builder()
                .id(userInfoBO.getId())
                .username(userInfoBO.getUsername())
                .build();
    }

    @Override
    protected UserInfoBO doBackward(UserInfoVO userInfoVO) {
        return UserInfoBO.builder()
                .id(userInfoVO.getId())
                .username(userInfoVO.getUsername())
                .build();
    }
}
