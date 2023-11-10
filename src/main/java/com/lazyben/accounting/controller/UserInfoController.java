package com.lazyben.accounting.controller;

import com.lazyben.accounting.model.dataobject.UserInfoDO;
import com.lazyben.accounting.model.viewobject.UserInfoVO;
import com.lazyben.accounting.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("{id}")
    public UserInfoVO getUserById(@PathVariable("id") long id) {
        return userInfoService.getUserById(id);
    }
}
