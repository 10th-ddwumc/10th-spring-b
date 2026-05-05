package com.example.umc10th.domain.home.controller;

import com.example.umc10th.domain.home.service.HomeService;
import com.example.umc10th.domain.mission.dto.response.MissionResDTO;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/home/missions")
    public ApiResponse<MissionResDTO.MissionListResDTO> getAvailableMissions(
            @RequestParam String address,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK,
                homeService.getAvailableMissions(address, PageRequest.of(page, size)));
    }

    @GetMapping("/home/progress")
    public ApiResponse<Long> getMissionProgress(@RequestParam Long memberId) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK,
                homeService.getCompletedMissionCount(memberId));
    }
}
