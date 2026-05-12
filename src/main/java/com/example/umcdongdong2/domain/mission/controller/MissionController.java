package com.example.umcdongdong2.domain.mission.controller;

import com.example.umcdongdong2.domain.mission.dto.MissionListReqDTO;
import com.example.umcdongdong2.domain.mission.dto.MissionListResDTO;
import com.example.umcdongdong2.domain.mission.dto.MissionVerificationReqDTO;
import com.example.umcdongdong2.domain.mission.dto.MissionVerificationRequestReqDTO;
import com.example.umcdongdong2.domain.mission.dto.MissionVerificationRequestResDTO;
import com.example.umcdongdong2.domain.mission.dto.MissionVerificationResDTO;
import com.example.umcdongdong2.domain.mission.dto.UserMissionsReqDTO;
import com.example.umcdongdong2.domain.mission.dto.UserMissionsResDTO;
import com.example.umcdongdong2.domain.mission.exception.code.MissionSuccessCode;
import com.example.umcdongdong2.domain.mission.service.MissionService;
import com.example.umcdongdong2.global.apiPayload.ApiResponse;
import com.example.umcdongdong2.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/user-missions/")
    public ApiResponse<UserMissionsResDTO.UserMissionsResponse> getUserMissions(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @ModelAttribute UserMissionsReqDTO.UserMissionsRequest dto
    ) {
        BaseSuccessCode code = MissionSuccessCode.OK;


        return ApiResponse.onSuccess(code, missionService.getUserMissions(authorization, dto));
    }

    @GetMapping("/missions/")
    public ApiResponse<MissionListResDTO.MissionListResponse> getMissionList(
            @ModelAttribute MissionListReqDTO.MissionListRequest dto
    ) {
        BaseSuccessCode code = MissionSuccessCode.OK;

        return ApiResponse.onSuccess(code, missionService.getMissionList(dto));
    }

    @PostMapping("/user-missions/{missionId}/verification-requests/")
    public ApiResponse<MissionVerificationRequestResDTO.MissionVerificationRequestResponse> requestMissionVerification(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long missionId,
            @RequestBody MissionVerificationRequestReqDTO.MissionVerificationRequest dto
    ) {
        BaseSuccessCode code = MissionSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, missionService.requestMissionVerification(authorization, missionId, dto));
    }

    @PostMapping("/user-missions/{missionId}/verification/")
    public ApiResponse<MissionVerificationResDTO.MissionVerificationResponse> verifyMission(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long missionId,
            @RequestBody MissionVerificationReqDTO.MissionVerificationRequest dto
    ) {
        BaseSuccessCode code = MissionSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, missionService.verifyMission(authorization, missionId, dto));
    }
}
