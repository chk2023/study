package com.ohgiraffers.sessionlogin.user.dto;

import com.ohgiraffers.sessionlogin.user.model.Authority;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDTO {
    private int userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private LocalDateTime registDatetime;
    private Authority authority;
}
