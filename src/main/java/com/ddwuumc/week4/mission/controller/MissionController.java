package com.ddwuumc.week4.mission.controller;

import com.ddwuumc.week4.global.code.GeneralCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.mission.dto.MissionResponseDto;
import com.ddwuumc.week4.mission.entity.MissionStatus;
import com.ddwuumc.week4.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @GetMapping("/api/missions")
    public ResponseEntity<ApiResponse<MissionResponseDto.MissionList>> getMissions(@RequestParam(value = "status") MissionStatus status,
                                                                             @RequestParam(value = "page") Integer page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralCode.OK, missionService.getMissions(status, page)));
    }

    @PatchMapping("api/missions/{id}/status")
    public ResponseEntity<ApiResponse<Long>> successMission(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralCode.OK, missionService.successMission(id)));
    }
}
