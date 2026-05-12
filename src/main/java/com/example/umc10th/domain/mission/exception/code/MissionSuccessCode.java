package com.example.umc10th.domain.mission.exception.code;

import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    MISSION_FOUND(HttpStatus.OK, "MISSION200_1", "미션 조회 성공"),
    MISSION_CREATED(HttpStatus.CREATED, "MISSION200_2", "미션 등록 성공"),
    MISSION_UPDATED(HttpStatus.OK, "MISSION200_3", "미션 수정 성공"),
    MISSION_DELETED(HttpStatus.OK, "MISSION200_4", "미션 삭제 성공"),
    MISSION_COMPLETED(HttpStatus.OK, "MISSION200_5", "미션 완료 성공");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
