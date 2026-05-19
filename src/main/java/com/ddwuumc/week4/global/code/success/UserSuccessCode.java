package com.ddwuumc.week4.global.code.success;

import com.ddwuumc.week4.global.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserSuccessCode implements BaseCode {
    USER_CREATED(HttpStatus.CREATED, "USER_201", "회원가입에 성공했습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
