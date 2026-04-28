package com.ddwuumc.week4.global.exception;

import com.ddwuumc.week4.global.code.BaseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProjectException extends RuntimeException {
    private final BaseCode errorCode;
}
