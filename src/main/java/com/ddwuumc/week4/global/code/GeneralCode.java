package com.ddwuumc.week4.global.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralCode implements BaseCode {
    // success
    OK(HttpStatus.OK, "COMMON_200", "성공적으로 요청을 처리했습니다"),
    CREATED(HttpStatus.CREATED, "COMMON_201", "성공적으로 자원을 생성했습니다"),


    // failure
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON_400", "잘못된 요청입니다"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_404", "해당 리소스를 찾을 수 없습니다"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "서버 측 오류입니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
