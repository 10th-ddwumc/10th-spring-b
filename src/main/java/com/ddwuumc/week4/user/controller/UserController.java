package com.ddwuumc.week4.user.controller;

import com.ddwuumc.week4.global.code.success.GeneralSuccessCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.global.common.PageDto.Offset;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionItem;
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
    public ResponseEntity<ApiResponse<Offset<MissionItem>>> getUserHome(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                        @RequestParam(defaultValue = "0") Integer pageSize) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralSuccessCode.OK, userService.getUserHome(pageNumber, pageSize)));
    }

    @GetMapping("/api/mypage")
    public ResponseEntity<ApiResponse<MyPage>> getUserMyPage() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralSuccessCode.OK, userService.getUserMyPage()));
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<ApiResponse<Long>> signup(@RequestBody UserRequestDto.SignupUser user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(GeneralSuccessCode.CREATED, userService.signup(user)));
    }
}
