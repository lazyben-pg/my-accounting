package com.lazyben.accounting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lazyben.accounting.converter.btv.UserInfoBTVConverter;
import com.lazyben.accounting.exception.GlobalExceptionHandler;
import com.lazyben.accounting.model.businessobject.UserInfoBO;
import com.lazyben.accounting.model.viewobject.UserInfoVO;
import com.lazyben.accounting.service.UserInfoService;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserInfoControllerTest {
    private MockMvc mockMvc;

    @Mock
    UserInfoService userInfoService;

    @Mock
    UserInfoBTVConverter userInfoBTVConverter;

    @InjectMocks
    UserInfoController userInfoController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userInfoController)
                                 .setControllerAdvice(new GlobalExceptionHandler())
                                 .build();
    }

    @AfterEach
    public void teardown() {
        reset(userInfoBTVConverter);
        reset(userInfoService);
    }

    @Test
    public void getUserById() throws Exception {
        // Arrange
        val id = 100L;
        val username = "xxx";
        val password = "12345";

        val userInfoBO = UserInfoBO.builder()
                                   .id(id)
                                   .username(username)
                                   .password(password)
                                   .build();
        val userInfoVO = UserInfoVO.builder()
                                   .id(id)
                                   .username(username)
                                   .build();
        when(userInfoBTVConverter.convert(userInfoBO)).thenReturn(userInfoVO);
        when(userInfoService.getUserById(id)).thenReturn(userInfoBO);

        // Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + id)
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(userInfoVO)));
        verify(userInfoService).getUserById(eq(id));
        verify(userInfoBTVConverter).convert(userInfoBO);
    }

    @Test
    public void getUserByIdWithInvalidParameterTest() throws Exception {
        // Arrange
        val id = -100L;

        // Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + id)
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().is4xxClientError())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.content().string("{\"statusCode\":400,\"message\":\"User id must greater than 0.\",\"errorType\":\"CLIENT\",\"errorCode\":\"INVALID_PARAMETER\"}"));

        verify(userInfoService, never()).getUserById(eq(id));
        verify(userInfoBTVConverter, never()).convert(any());
    }

    @Test
    public void getUserByIdWithUserNotFoundTest() throws Exception {
        // Arrange
        val id = 100L;
        when(userInfoService.getUserById(id)).thenReturn(null);

        // Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + id)
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().is4xxClientError())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.content().string("{\"statusCode\":404,\"message\":\"User id 100 not found.\",\"errorType\":\"CLIENT\",\"errorCode\":\"RESOURCE_NOT_FOUND\"}"));

        verify(userInfoService).getUserById(eq(id));
        verify(userInfoBTVConverter, never()).convert(any());
    }
}
