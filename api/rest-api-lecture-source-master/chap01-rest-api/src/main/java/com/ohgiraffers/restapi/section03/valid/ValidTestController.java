package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<Void> findUserByNo () throws UserNotFoundException {

        boolean check = true;
        if(check) {
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        }

        return ResponseEntity.ok().build();
    }

    /* @Valid : 클라이언트에서 전달 되는 파라미터에 대한 유효성 검사를 수행
    * UserDTO 내부의 어노테이션 설정에 따름
    * */
    @PostMapping("/users")
    public ResponseEntity<Void> registUser(@Valid @RequestBody UserDTO user) {

        return ResponseEntity
                .created(URI.create("/valid/users/1"))
                .build();
    }


















}
