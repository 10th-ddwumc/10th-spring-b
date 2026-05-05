package com.example.umc10th.domain.review.exception.code;


import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    // 리뷰 작성 성공
    ADD_REVIEW_OK(HttpStatus.OK, "REVIEW200_1", "성공적으로 리뷰를 작성했습니다."),

    // 리뷰 조회 성공
    GET_REVIEW_OK(HttpStatus.OK, "REVIEW200_2", "리뷰 조회에 성공했습니다."),

    // 리뷰 수정 성공
    UPDATE_REVIEW_OK(HttpStatus.OK, "REVIEW200_3", "리뷰 수정에 성공했습니다."),

    // 리뷰 삭제 성공
    DELETE_REVIEW_OK(HttpStatus.OK, "REVIEW200_4", "리뷰 삭제에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
