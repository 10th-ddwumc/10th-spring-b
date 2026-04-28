package com.ddwuumc.week4.user.controller;

import com.ddwuumc.week4.global.code.GeneralCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.user.dto.UserRequestDto;
import com.ddwuumc.week4.user.dto.UserResponseDto;
import com.ddwuumc.week4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/home")
    public ResponseEntity<ApiResponse<UserResponseDto.Home>> getUserHome() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(GeneralCode.OK, userService.getUserHome()));
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<ApiResponse<Long>> signup(@RequestBody UserRequestDto.SignupUser user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(GeneralCode.CREATED, userService.signup(user)));
    }
}
