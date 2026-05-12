package com.example.umc10th.domain.member.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {
    GET_MY_PAGE(HttpStatus.OK, "MEMBER200_1", "마이페이지 조회 성공"),
    GET_MY_REVIEWS(HttpStatus.OK, "MEMBER200_2", "작성한 리뷰 목록 조회 성공"),

    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
