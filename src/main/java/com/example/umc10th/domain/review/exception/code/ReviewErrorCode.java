package com.example.umc10th.domain.review.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "리뷰를 찾을 수 없습니다."),
    REVIEW_ALREADY_EXISTS(HttpStatus.CONFLICT, "REVIEW409_1", "이미 리뷰를 작성했습니다."),
    REVIEW_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "REVIEW401_1", "리뷰 작성 권한이 없습니다."),
    REVIEW_FORBIDDEN(HttpStatus.FORBIDDEN, "REVIEW403_1", "해당 리뷰에 접근할 수 없습니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;
}