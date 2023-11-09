package com.lazyben.accounting.model.businessobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoBO {
    private Long id;

    private String username;

    private String password;
}