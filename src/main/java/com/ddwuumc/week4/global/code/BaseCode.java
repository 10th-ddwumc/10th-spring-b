package com.ddwuumc.week4.global.code;

import org.springframework.http.HttpStatus;

public interface BaseCode {
    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
