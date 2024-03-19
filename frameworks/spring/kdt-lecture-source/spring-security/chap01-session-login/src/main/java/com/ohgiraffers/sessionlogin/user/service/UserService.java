package com.ohgiraffers.sessionlogin.user.service;

import com.ohgiraffers.sessionlogin.user.dao.UserMapper;
import com.ohgiraffers.sessionlogin.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void joinUser(UserDTO user) {
        /* 평문으로 된 비밀번호를 암호화하여 DB에 저장한다. */
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
        userMapper.registUser(user);
    }
}
