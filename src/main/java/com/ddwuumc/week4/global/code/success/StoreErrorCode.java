package com.ddwuumc.week4.global.code.success;

import com.ddwuumc.week4.global.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum StoreErrorCode implements BaseCode {
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_404", "존재하지 않는 매장입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
