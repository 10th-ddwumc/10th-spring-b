package com.ddwuumc.week4.global.handler;

import com.ddwuumc.week4.global.code.BaseCode;
import com.ddwuumc.week4.global.code.GeneralCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.global.exception.ProjectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {
    // 프로젝트에서 발생한 예외 처리
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<ApiResponse<Void>> handleMemberException(ProjectException e) {
        BaseCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.onFailure(errorCode, null));
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        BaseCode code = GeneralCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus()).body(ApiResponse.onFailure(code, ex.getMessage()));
    }
}
