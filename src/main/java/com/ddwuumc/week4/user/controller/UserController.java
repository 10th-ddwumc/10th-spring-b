package com.ddwuumc.week4.user.controller;

import com.ddwuumc.week4.global.code.GeneralCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionList;
import com.ddwuumc.week4.user.dto.UserRequestDto;
import com.ddwuumc.week4.user.dto.UserResponseDto.MyPage;
import com.ddwuumc.week4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/home")
    public ResponseEntity<ApiResponse<MissionList>> getUserHome(@RequestParam(value = "page") Long page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralCode.OK, userService.getUserHome(page)));
    }

    @GetMapping("/api/mypage")
    public ResponseEntity<ApiResponse<MyPage>> getUserMyPage() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralCode.OK, userService.getUserMyPage()));
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<ApiResponse<Long>> signup(@RequestBody UserRequestDto.SignupUser user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(GeneralCode.CREATED, userService.signup(user)));
    }
}
