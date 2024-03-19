package com.ohgiraffers.sessionlogin.user.controller;

import com.ohgiraffers.sessionlogin.auth.model.CustomUser;
import com.ohgiraffers.sessionlogin.user.dto.UserDTO;
import com.ohgiraffers.sessionlogin.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageSourceAccessor messageSourceAccessor;

    @GetMapping("/login")
    public void getLoginPage(){}

    @GetMapping("/join")
    public void getJoinPage(){}

    @PostMapping("/join")
    public String memberjoin(@ModelAttribute UserDTO user, RedirectAttributes rttr) {

        userService.joinUser(user);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.join"));

        return "redirect:/user/login";
    }

    @GetMapping("/mypage")
    public void getMypage(@AuthenticationPrincipal CustomUser user) {
        log.info("로그인 한 유저의 번호 : {}", user.getUserNo());
        log.info("로그인 한 유저의 이름 : {}", user.getUserName());
    }
}
