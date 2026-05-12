package com.ddwuumc.week4.mission.controller;

import com.ddwuumc.week4.global.code.error.GeneralSuccessCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.global.common.PageDto.Offset;
import com.ddwuumc.week4.mission.dto.MissionRequestDto.MissionRequest;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionItem;
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

    @PostMapping("/api/missions")
    public ResponseEntity<ApiResponse<Offset<MissionItem>>> getMissions(@RequestParam MissionStatus status,
                                                                        @RequestParam(defaultValue = "0") Integer pageNumber,
                                                                        @RequestParam(defaultValue = "0") Integer pageSize,
                                                                        @RequestBody MissionRequest missionRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralSuccessCode.OK, missionService.getMissions(status, pageNumber, pageSize, missionRequest)));
    }

    @PatchMapping("api/missions/{id}/status")
    public ResponseEntity<ApiResponse<Long>> successMission(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralSuccessCode.OK, missionService.successMission(id)));
    }
}
