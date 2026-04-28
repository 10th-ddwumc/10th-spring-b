package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.dto.request.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.response.MissionResDTO;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/mission")
    public ApiResponse<MissionResDTO> getMission(
            @RequestParam String region,
            @RequestParam MissionStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.getMission(region, status, page, size));
    }

    @PatchMapping("/{missionId}/completed")
    public ResponseEntity<Void> updateMissionStatus(
            @PathVariable Long missionId,
            @RequestBody @Valid MissionReqDTO.MissionStatusReqDTO request
    ) {
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.updateMissionStatus(missionId, request));
    }
}
