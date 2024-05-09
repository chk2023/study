package com.ohgiraffers.comprehensive.member.service;

import com.ohgiraffers.comprehensive.auth.dto.LoginDto;
import com.ohgiraffers.comprehensive.member.domain.entity.Member;
import com.ohgiraffers.comprehensive.member.domain.repository.MemberRepository;
import com.ohgiraffers.comprehensive.member.dto.request.MemberSignupRequest;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public void signup(final MemberSignupRequest memberRequest) {

        final Member newMember = Member.of(
                memberRequest.getMemberId(),
                passwordEncoder.encode(memberRequest.getMemberPassword()),
                memberRequest.getMemberName(),
                memberRequest.getMemberEmail()
        );

        memberRepository.save(newMember);
    }

    @Transactional(readOnly = true)
    public LoginDto findByMemberId(String memberId) {

        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));

        return LoginDto.from(member);
    }

    public void updateRefreshToken(String memberId, String refreshToken) {

        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));
        member.updateRefreshToken(refreshToken);

    }
}
