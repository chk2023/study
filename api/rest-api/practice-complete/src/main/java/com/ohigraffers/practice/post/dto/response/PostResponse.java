package com.ohigraffers.practice.post.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ohigraffers.practice.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PostResponse {

    private Long code;
    private String title;
    private String content;
    private String writer;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime modifiedAt;

    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getCode(),
                post.getTitle(),
                post.getContent(),
                post.getWriter(),
                post.getCreatedAt(),
                post.getModifiedAt()
        );
    }
}
