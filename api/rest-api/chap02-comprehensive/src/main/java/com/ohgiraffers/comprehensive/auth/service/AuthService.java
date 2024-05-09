package com.ohgiraffers.comprehensive.auth.service;

import com.ohgiraffers.comprehensive.auth.dto.LoginDto;
import com.ohgiraffers.comprehensive.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        LoginDto loginDto = memberService.findByMemberId(memberId);

        return User.builder()
                .username(loginDto.getMemberId())
                .password(loginDto.getMemberPassword())
                .roles(loginDto.getMemberRole().name())
                .build();
    }

    public void updateRefreshToken(String memberId, String refreshToken) {
        memberService.updateRefreshToken(memberId, refreshToken);
    }
}
