package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    // 미션 성공 처리 API (특정 미션을 성공 상태로 변경)
    @PatchMapping("/api/{memberId}/missions/{missionId}/success")
    public ApiResponse<MissionResDTO.Success> success(
            @PathVariable("missionId") Long missionId,
            @PathVariable("memberId") Long memberId
    ) {
        BaseSuccessCode code = MissionSuccessCode.COMPLETE_MISSION_OK;
        return ApiResponse.onSuccess(code, missionService.success(missionId, memberId));
    }

    // 완료/미완료 미션 조회 API (성공 여부 기준 + 커서 기반 페이징)
    @GetMapping("/api/{memberId}/missions")
    public ApiResponse<List<MissionResDTO.GetMissions>> getMissions(
            @RequestParam Boolean isSuccess,
            @PathVariable("memberId") Long memberId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastEndDate, // 종료일 기준 커서 페이징용 날짜
            @RequestParam(required = false) Long lastId, // 동일 날짜 내 정렬을 위한 커서 ID
            @RequestParam(defaultValue = "10") int pageSize // 한 번에 조회할 미션 개수
    ) {
        BaseSuccessCode code = MissionSuccessCode.GET_MISSION_LIST_OK;
        return ApiResponse.onSuccess(code, missionService.getMissions(isSuccess, memberId, lastEndDate, lastId, pageSize));
    }
}
