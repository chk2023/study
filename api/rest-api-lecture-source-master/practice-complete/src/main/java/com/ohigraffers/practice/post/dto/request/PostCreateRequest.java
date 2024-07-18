package com.ohigraffers.practice.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Post 작성 요청 파라미터")
public class PostCreateRequest {

    @Schema(description = "Post 제목")
    @NotBlank(message = "Post 제목은 반드시 입력 되어야 하며 공백일 수 없습니다.")
    private String title;

    @Schema(description = "Post 내용")
    @NotBlank(message = "Post 내용은 반드시 입력 되어야 하며 공백일 수 없습니다.")
    private String content;

    @Schema(description = "Post 작성자")
    @NotBlank(message = "Post 작성자는 반드시 입력 되어야 하며 공백일 수 없습니다.")
    private String writer;

}

