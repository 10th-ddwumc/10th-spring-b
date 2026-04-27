package com.example.umc10th.domain.mission.exception.code;

import com.example.umc10th.global.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    // 미션 생성 성공
    CREATE_MISSION_OK(HttpStatus.OK, "MISSION200_1", "미션 생성에 성공했습니다."),

    // 미션 조회 성공
    GET_MISSION_OK(HttpStatus.OK, "MISSION200_2", "미션 조회에 성공했습니다."),

    // 미션 목록 조회 성공
    GET_MISSION_LIST_OK(HttpStatus.OK, "MISSION200_3", "미션 목록 조회에 성공했습니다."),

    // 미션 수정 성공
    UPDATE_MISSION_OK(HttpStatus.OK, "MISSION200_4", "미션 수정에 성공했습니다."),

    // 미션 삭제 성공
    DELETE_MISSION_OK(HttpStatus.OK, "MISSION200_5", "미션 삭제에 성공했습니다."),

    // 미션 성공 처리
    COMPLETE_MISSION_OK(HttpStatus.OK, "MISSION200_6", "미션 성공 처리에 성공했습니다."),

    // 미션 실패 처리
    FAIL_MISSION_OK(HttpStatus.OK, "MISSION200_7", "미션 실패 처리에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
