package com.example.umcdongdong2.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public enum GeneralSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "200", "SUCCESS");

    private final HttpStatus status;
    private final String code;
    private final String message;

    GeneralSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
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
