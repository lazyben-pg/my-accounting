package com.lazyben.accounting.dao;

import com.lazyben.accounting.dao.mapper.UserInfoDOMapper;
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
public class UserInfoDaoTest {
    @Mock
    UserInfoDOMapper userInfoDOMapper;

    @InjectMocks
    UserInfoDaoImpl userInfoDao;

    @Test
    public void testGetUserById() {
        // Arrange
        val id = 100L;
        val userInfoDo = UserInfoDO.builder()
                                   .id(id)
                                   .username("xxx")
                                   .password("12345")
                                   .createTime(new Date())
                                   .updateTime(new Date())
                                   .build();
        when(userInfoDOMapper.selectByPrimaryKey(id)).thenReturn(userInfoDo);

        // Act
        val result = userInfoDao.getUserById(id);

        // Assert
        assertEquals(userInfoDo, result);
        verify(userInfoDOMapper).selectByPrimaryKey(eq(id));
    }
}
