package com.ohgiraffers.comprehensive.common.exception.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExceptionResponse {

    private final int code;
    private final String message;

    public static ExceptionResponse of(int code, String message) {
        return new ExceptionResponse(code, message);
    }
}
