package com.ddwuumc.week4.global.code.success;

import com.ddwuumc.week4.global.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseCode {
    REVIEW_OK(HttpStatus.OK, "REVIEW_200", "성공적으로 리뷰를 조회했습니다"),
    REVIEW_CREATED(HttpStatus.CREATED, "REVIEW_201", "성공적으로 리뷰를 생성했습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
