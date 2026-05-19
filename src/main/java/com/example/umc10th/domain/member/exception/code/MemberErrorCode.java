package com.example.umc10th.domain.member.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4001", "존재하지 않는 멤버입니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "MEMBER4002", "이미 존재하는 이메일입니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
