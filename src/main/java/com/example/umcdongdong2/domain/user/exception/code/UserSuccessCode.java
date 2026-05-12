package com.example.umcdongdong2.domain.user.exception.code;

import com.example.umcdongdong2.global.apiPayload.code.BaseSuccessCode;
import org.springframework.http.HttpStatus;

public enum UserSuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK, "MEMBER200_1", "유저 조회 성공");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    UserSuccessCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }


    @Override
    public HttpStatus getStatus() {
        return this.httpStatus;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
