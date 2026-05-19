package com.ddwuumc.week4.global.code.error;

import com.ddwuumc.week4.global.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralErrorCode implements BaseCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON_400", "잘못된 요청입니다"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON_401", "인증되지 않은 요청입니다"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_404", "해당 리소스를 찾을 수 없습니다"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "접근 권한이 없습니다"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "서버 측 오류입니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
