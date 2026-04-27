package com.example.umc10th.domain.member.exception.code;


import com.example.umc10th.global.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    // 회원가입 성공
    SIGNUP_OK(HttpStatus.OK, "USER200_1", "회원가입에 성공했습니다."),

    // 로그인 성공
    LOGIN_OK(HttpStatus.OK, "USER200_2", "로그인에 성공했습니다."),

    // 사용자 조회 성공
    GET_MEMBER_OK(HttpStatus.OK, "USER200_3", "사용자 조회에 성공했습니다."),

    // 사용자 정보 수정 성공
    UPDATE_MEMBER_OK(HttpStatus.OK, "USER200_4", "사용자 정보 수정에 성공했습니다."),

    // 회원 탈퇴 성공
    DELETE_MEMBER_OK(HttpStatus.OK, "USER200_5", "회원 탈퇴에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

