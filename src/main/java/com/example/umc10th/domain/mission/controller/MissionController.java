package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.member.entity.mapping.MemberMission;
import com.example.umc10th.domain.mission.dto.request.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.response.MissionResDTO;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public ApiResponse<MissionResDTO.MissionListResDTO> getMyMissions(
            @RequestBody @Valid MissionReqDTO.MyMissionReqDTO request,
            @RequestParam MissionStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        MissionResDTO.MissionListResDTO result =
                missionService.getMyMissions(request.getMemberId(), status, PageRequest.of(page, size));
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    @PatchMapping("/{missionId}/completed")
    public ApiResponse<Void> updateMissionStatus(
            @PathVariable Long missionId,
            @RequestBody @Valid MissionReqDTO.MissionStatusReqDTO request
    ) {
        missionService.updateMissionStatus(missionId, request.getStatus());
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }


}
