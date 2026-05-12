package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {
    private final MissionService missionService;

    @GetMapping("/missions")
    public ApiResponse<MissionResDTO.Pagination<MissionResDTO.Mission>> getMissions(
            @RequestParam Long userId,
            @RequestParam Integer pageSize,
            @RequestParam Integer pageNumber,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) Boolean completed
    ){
        BaseSuccessCode code = MissionSuccessCode.MISSION_FOUND;
        return ApiResponse.onSuccess(code, missionService.getMissions(userId, pageSize, pageNumber, sort, completed));
    }

    @PatchMapping("/missions/{id}/complete")
    public ApiResponse<MissionResDTO.missionCompleteRes> missionComplete(
        @PathVariable(name="id") Long missionId
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.completeMission(missionId));
    }

}
