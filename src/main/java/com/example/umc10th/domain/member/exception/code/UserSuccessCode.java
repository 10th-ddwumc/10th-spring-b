package com.example.umc10th.domain.member.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserSuccessCode implements BaseSuccessCode {

    USER_FOUND(HttpStatus.OK, "USER200_1", "사용자 조회 성공"),
    USER_CREATED(HttpStatus.CREATED, "USER201_1", "사용자 등록 성공"),
    USER_UPDATED(HttpStatus.OK, "USER200_2", "사용자 수정 성공"),
    USER_DELETED(HttpStatus.OK, "USER200_3", "사용자 삭제 성공");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
