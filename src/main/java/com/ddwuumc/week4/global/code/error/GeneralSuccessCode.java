package com.ddwuumc.week4.global.code.error;

import com.ddwuumc.week4.global.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseCode {
    OK(HttpStatus.OK, "COMMON_200", "성공적으로 요청을 처리했습니다"),
    CREATED(HttpStatus.CREATED, "COMMON_201", "성공적으로 자원을 생성했습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
