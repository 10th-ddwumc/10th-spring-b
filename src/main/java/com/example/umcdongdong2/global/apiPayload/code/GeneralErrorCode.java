package com.example.umcdongdong2.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public enum GeneralErrorCode implements BaseErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400_1", "Bad Request"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401_1", "Unauthorized"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403_1", "Forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404_1", "Not Found");

    private final HttpStatus status;
    private final String code;
    private final String message;

    GeneralErrorCode(HttpStatus status, String code, String message) {
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
