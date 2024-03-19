package com.ohgiraffers.sessionlogin.auth.model;

import com.ohgiraffers.sessionlogin.user.dto.UserDTO;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {

    private int userNo;
    private String userName;

    public CustomUser(UserDTO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserId(), user.getUserPwd(), authorities);
        this.userNo = user.getUserNo();
        this.userName = user.getUserName();
    }

    @Override
    public String toString() {
        return super.toString() + ", userNo : " + userNo + ", userName : " + userName;
    }
}
