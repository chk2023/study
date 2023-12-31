package com.study.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data // 상태를 데이터로 사용하기 위해, /board/write 값을 /board/writepro로 넘겨주기 위해.
public class Board {

    @Id //프라이머리 키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
}
