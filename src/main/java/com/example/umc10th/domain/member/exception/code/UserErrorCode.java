package com.example.umc10th.domain.member.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements BaseErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER404_1", "사용자를 찾을 수 없습니다."),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "USER409_1", "이미 존재하는 사용자입니다."),
    UNAUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "USER401_1", "인증되지 않은 사용자입니다."),
    FORBIDDEN_USER(HttpStatus.FORBIDDEN, "USER403_1", "접근 권한이 없습니다."),
    INACTIVE_USER(HttpStatus.FORBIDDEN, "USER403_2", "비활성화된 사용자입니다."),
    WITHDRAWN_USER(HttpStatus.FORBIDDEN, "USER403_3", "탈퇴한 사용자입니다."),
    INVALID_USER_STATUS(HttpStatus.BAD_REQUEST, "USER400_1", "유효하지 않은 사용자 상태입니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
