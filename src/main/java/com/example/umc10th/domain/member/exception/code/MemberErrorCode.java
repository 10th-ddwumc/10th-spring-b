package com.example.umc10th.domain.member.exception.code;


import com.example.umc10th.global.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    // 사용자 조회 실패
    NOT_FOUND(HttpStatus.NOT_FOUND, "USER404_1", "사용자를 찾을 수 없습니다."),

    // 이메일 중복
    EMAIL_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER400_1", "이미 사용 중인 이메일입니다."),

    // 닉네임 중복
    NICKNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER400_2", "이미 사용 중인 닉네임입니다."),

    // 비밀번호 불일치
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "USER401_1", "비밀번호가 일치하지 않습니다."),

    // 로그인 필요 (인증 실패)
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "USER401_2", "로그인이 필요합니다."),

    // 접근 권한 없음
    FORBIDDEN(HttpStatus.FORBIDDEN, "USER403_1", "접근 권한이 없습니다."),

    // 탈퇴한 사용자
    USER_DEACTIVATED(HttpStatus.BAD_REQUEST, "USER400_3", "탈퇴한 사용자입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
