package com.example.umc10th.domain.review.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    REVIEW_FOUND(HttpStatus.OK, "REVIEW200_1", "리뷰 조회 성공"),
    REVIEW_CREATED(HttpStatus.CREATED, "REVIEW201_1", "리뷰 작성 성공"),
    REVIEW_UPDATED(HttpStatus.OK, "REVIEW200_2", "리뷰 수정 성공"),
    REVIEW_DELETED(HttpStatus.OK, "REVIEW200_3", "리뷰 삭제 성공");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
