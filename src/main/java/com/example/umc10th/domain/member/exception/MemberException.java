package com.example.umc10th.domain.member.exception;

import com.example.umc10th.global.code.BaseErrorCode;
import com.example.umc10th.global.exception.ProjectException;

public class MemberException extends ProjectException {
    public MemberException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
