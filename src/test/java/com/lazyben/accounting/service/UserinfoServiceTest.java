package com.lazyben.accounting.service;

import com.lazyben.accounting.converter.dtb.UserInfoDTBConverter;
import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import com.lazyben.accounting.model.dataobject.UserInfoDO;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserinfoServiceTest {
    @Mock
    UserInfoDao userInfoDao;

    @Mock
    UserInfoDTBConverter userInfoDTBConverter;

    @InjectMocks
    UserInfoServiceImpl userInfoService;

    @Test
    public void getUserInfoByIdTest() {
        // Arrange
        val id = 100L;
        val username = "xxx";
        val password = "12345";
        val curDate = new Date();
        val userInfoDO = UserInfoDO.builder()
                                   .id(id)
                                   .username(username)
                                   .password(password)
                                   .createTime(curDate)
                                   .updateTime(curDate)
                                   .build();
        val userInfoBO = UserInfoBO.builder()
                                   .id(id)
                                   .username(username)
                                   .password(password)
                                   .build();
        when(userInfoDTBConverter.convert(userInfoDO)).thenReturn(userInfoBO);
        when(userInfoDao.getUserById(id)).thenReturn(userInfoDO);

        // Act
        val result = userInfoService.getUserById(id);

        // Assert
        assertEquals(userInfoBO, result);
        verify(userInfoDao).getUserById(eq(id));
        verify(userInfoDTBConverter).convert(eq(userInfoDO));
    }
}
