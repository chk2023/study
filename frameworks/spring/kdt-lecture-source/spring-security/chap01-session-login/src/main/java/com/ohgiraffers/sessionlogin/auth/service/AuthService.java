package com.ohgiraffers.sessionlogin.auth.service;

import com.ohgiraffers.sessionlogin.auth.model.CustomUser;
import com.ohgiraffers.sessionlogin.user.dao.UserMapper;
import com.ohgiraffers.sessionlogin.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /* 전달 된 id 확인 */
        log.info("username : {}", username);

        UserDTO user = userMapper.findUserById(username);

        /* 조회 된 유저 확인 */
        log.info("user : {}", user);

        /* 일치하는 아이디가 없어서 조회 된 유저가 없는 경우 */
        if(user == null) throw new UsernameNotFoundException("username not found");

        /* 권한 만들기 */
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getAuthority().name()));

        /* UserDetails를 구현하는 User 객체를 생성해서 반환 */
//        return new User(user.getUserId(), user.getUserPwd(), authorities);

        /* User 객체에는 담을 수 없는 추가 정보를 CustomUser 객체로 변경하여 처리 */
        return new CustomUser(user, authorities);
    }
}
