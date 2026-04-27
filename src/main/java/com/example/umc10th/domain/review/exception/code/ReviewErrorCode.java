package com.example.umc10th.domain.review.exception.code;

import com.example.umc10th.global.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    // 리뷰를 찾을 수 없는 경우
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "리뷰를 찾을 수 없습니다."),

    // 리뷰 작성 권한이 없는 경우
    REVIEW_FORBIDDEN(HttpStatus.FORBIDDEN, "REVIEW403_1", "리뷰 작성 권한이 없습니다."),

    // 리뷰 내용이 비어있는 경우
    REVIEW_CONTENT_EMPTY(HttpStatus.BAD_REQUEST, "REVIEW400_2", "리뷰 내용이 비어있습니다."),

    // 리뷰 내용 길이 초과
    REVIEW_CONTENT_TOO_LONG(HttpStatus.BAD_REQUEST, "REVIEW400_3", "리뷰 내용이 너무 깁니다."),

    // 평점 값이 유효하지 않은 경우
    INVALID_RATING_VALUE(HttpStatus.BAD_REQUEST, "REVIEW400_4", "유효하지 않은 평점입니다."),

    // 리뷰 수정 권한이 없는 경우
    REVIEW_UPDATE_FORBIDDEN(HttpStatus.FORBIDDEN, "REVIEW403_2", "리뷰 수정 권한이 없습니다."),

    // 리뷰 삭제 권한이 없는 경우
    REVIEW_DELETE_FORBIDDEN(HttpStatus.FORBIDDEN, "REVIEW403_3", "리뷰 삭제 권한이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
