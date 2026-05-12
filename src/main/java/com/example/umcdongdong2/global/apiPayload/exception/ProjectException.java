package com.example.umcdongdong2.global.apiPayload.exception;

import com.example.umcdongdong2.global.apiPayload.code.BaseErrorCode;

public class ProjectException extends RuntimeException {
    public ProjectException(String message) {
        super(message);
    }

    public BaseErrorCode getErrorCode() {
        return null;
    }
}
