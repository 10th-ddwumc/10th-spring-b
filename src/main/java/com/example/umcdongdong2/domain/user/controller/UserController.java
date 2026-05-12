package com.example.umcdongdong2.domain.user.controller;

import com.example.umcdongdong2.domain.user.dto.*;
import com.example.umcdongdong2.domain.user.exception.code.UserSuccessCode;
import com.example.umcdongdong2.domain.user.service.UserService;
import com.example.umcdongdong2.global.apiPayload.ApiResponse;
import com.example.umcdongdong2.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/signup/")
    public ApiResponse<UserSignupResDTO.UserSignupResponse> signup(
            @RequestBody UserSignupReqDTO.UserSignupRequest dto
    ) {
        BaseSuccessCode code = UserSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, userService.signup(dto));
    }

    @PostMapping("/auth/login/")
    public ApiResponse<UserLoginResDTO.UserLoginResponse> login(
            @RequestBody UserLoginReqDTO.UserLoginRequest dto
    ) {
        BaseSuccessCode code = UserSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, userService.login(dto));
    }

    @GetMapping("/users/points/")
    public ApiResponse<UserPointsResDTO.UserPointsResponse> getPoints(
            @RequestHeader("Authorization") String authorization,
            @ModelAttribute UserPointsReqDTO.UserPointsRequest dto
    ) {
        BaseSuccessCode code = UserSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, userService.getPoints(authorization, dto));
    }

    @GetMapping("/users/notifications/")
    public ApiResponse<UserNotificationsResDTO.UserNotificationsResponse> getNotifications(
            @RequestHeader("Authorization") String authorization,
            @ModelAttribute UserNotificationsReqDTO.UserNotificationsRequest dto
    ) {
        BaseSuccessCode code = UserSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, userService.getNotifications(authorization, dto));
    }

    @GetMapping("/users/my-page")
    public ApiResponse<UserMypageResDTO.UserMypageResponse> getMyPage(
            @RequestHeader("Authorization") String authorization,
            @ModelAttribute UserMypageReqDTO.UserMypageRequest dto
    ){
        BaseSuccessCode code = UserSuccessCode.OK;

        return ApiResponse.onSuccess(code, userService.getMyPage(dto));
    }
}
