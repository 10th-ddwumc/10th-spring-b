package com.example.umcdongdong2.domain.review.exception.code;

import com.example.umcdongdong2.global.apiPayload.code.BaseSuccessCode;
import org.springframework.http.HttpStatus;

public enum ReviewSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "REVIEW200_1", "리뷰 요청에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ReviewSuccessCode(HttpStatus status, String code, String message) {
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
