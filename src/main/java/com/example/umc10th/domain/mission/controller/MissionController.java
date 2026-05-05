package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {
    private final MissionService missionService;
    @GetMapping("/missions")
    public ApiResponse<MissionResDTO.PageResDTO<MissionResDTO.missionRes>> missions(
            @RequestParam Long userId,
            @PageableDefault(size=10, page=0) Pageable pageable
    ){
        BaseSuccessCode code = MissionSuccessCode.MISSION_FOUND;
        return ApiResponse.onSuccess(code, missionService.missions(userId, pageable));
    }

    @PatchMapping("/missions/{id}/complete")
    public ApiResponse<MissionResDTO.missionCompleteRes> missionComplete(
        @PathVariable(name="id") Long missionId
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.completeMission(missionId));
    }


}
