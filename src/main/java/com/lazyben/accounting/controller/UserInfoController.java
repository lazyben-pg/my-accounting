package com.lazyben.accounting.controller;

import com.lazyben.accounting.exception.InvalidParameterException;
import com.lazyben.accounting.exception.ResourceNotFoundException;
import com.lazyben.accounting.model.viewobject.UserInfoVO;
import com.lazyben.accounting.service.UserInfoService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserInfoVO> getUserById(@PathVariable("id") long id) {
        if (id <= 0L) {
            throw new InvalidParameterException("User id must greater than 0.");
        }
        var userInfo = Optional.ofNullable(userInfoService.getUserById(id))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User id %s not found.", id)));

        return ResponseEntity.ok(userInfo);
    }
}
