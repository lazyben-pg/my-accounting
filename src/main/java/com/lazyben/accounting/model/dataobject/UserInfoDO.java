package com.lazyben.accounting.model.dataobject;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDO {
    private Long id;

    private String username;

    private String password;

    private Date createTime;

    private Date updateTime;
}