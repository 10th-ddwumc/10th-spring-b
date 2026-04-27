package com.example.umc10th.domain.mission.exception.code;

import com.example.umc10th.global.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    // 미션을 찾을 수 없는 경우
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404_1", "미션을 찾을 수 없습니다."),

    // 미션 접근 권한이 없는 경우
    MISSION_FORBIDDEN(HttpStatus.FORBIDDEN, "MISSION403_1", "해당 미션에 대한 접근 권한이 없습니다."),

    // 이미 완료된 미션을 다시 완료하려는 경우
    ALREADY_COMPLETED(HttpStatus.BAD_REQUEST, "MISSION400_1", "이미 완료된 미션입니다."),

    // 이미 실패 처리된 미션인 경우
    ALREADY_FAILED(HttpStatus.BAD_REQUEST, "MISSION400_2", "이미 실패 처리된 미션입니다."),

    // 유효하지 않은 상태 변경 요청
    INVALID_MISSION_STATUS(HttpStatus.BAD_REQUEST, "MISSION400_3", "유효하지 않은 미션 상태 변경 요청입니다."),

    // 미션이 해당 사용자에게 할당되지 않은 경우
    MISSION_NOT_ASSIGNED(HttpStatus.BAD_REQUEST, "MISSION400_4", "해당 미션은 이 사용자에게 할당되지 않았습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
