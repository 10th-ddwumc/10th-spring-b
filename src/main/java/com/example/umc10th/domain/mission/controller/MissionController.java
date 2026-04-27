package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.ApiResponse;
import com.example.umc10th.global.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    // 미션 성공 누르기
    @PatchMapping("/api/{memberId}/missions/{missionId}/success")
    public ApiResponse<MissionResDTO.Success> success(
            @PathVariable("missionId") Long missionId,
            @PathVariable("memberId") Long memberId
    ) {
        BaseSuccessCode code = MissionSuccessCode.COMPLETE_MISSION_OK;
        return ApiResponse.onSuccess(code, missionService.success(missionId, memberId));
    }

    // 미션 실패 누르기
    @PatchMapping("/api/{memberId}/missions/{missionId}/fail")
    public ApiResponse<MissionResDTO.Success> fail(
            @PathVariable("missionId") Long missionId,
            @PathVariable("memberId") Long memberId
    ) {
        BaseSuccessCode code = MissionSuccessCode.FAIL_MISSION_OK;
        return ApiResponse.onSuccess(code, missionService.fail(missionId, memberId));
    }

    // 미션 조회
    @GetMapping("/api/{memberId}/missions")
    public ApiResponse<List<MissionResDTO.GetMissions>> getMissions(
            @RequestParam Boolean isSuccess,
            @PathVariable("memberId") Long memberId
    ) {
        BaseSuccessCode code = MissionSuccessCode.GET_MISSION_LIST_OK;
        return ApiResponse.onSuccess(code, missionService.getMissions(isSuccess, memberId));
    }
}
