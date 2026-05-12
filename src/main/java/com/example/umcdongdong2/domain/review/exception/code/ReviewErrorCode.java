package com.example.umcdongdong2.domain.review.exception.code;

import com.example.umcdongdong2.global.apiPayload.code.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum ReviewErrorCode implements BaseErrorCode {

    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "리뷰를 찾을 수 없습니다."),
    REVIEW_BAD_REQUEST(HttpStatus.BAD_REQUEST, "REVIEW400_1", "잘못된 리뷰 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ReviewErrorCode(HttpStatus status, String code, String message) {
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
