package com.example.umcdongdong2.domain.mission.exception.code;

import com.example.umcdongdong2.global.apiPayload.code.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum MissionErrorCode implements BaseErrorCode {

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404_1", "미션을 찾을 수 없습니다."),
    MISSION_BAD_REQUEST(HttpStatus.BAD_REQUEST, "MISSION400_1", "잘못된 미션 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    MissionErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
