package com.example.umc10th.domain.member.controller;

import com.example.umc10th.domain.member.dto.UserReqDTO;
import com.example.umc10th.domain.member.dto.UserResDTO;
import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.member.exception.code.UserSuccessCode;
import com.example.umc10th.domain.member.service.UserService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("api/home")
    public ApiResponse<UserResDTO.PageResDTO<UserResDTO.homeRes>> home(
            @RequestParam String region,
            @PageableDefault (size=10, page=0) Pageable pageable
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, userService.home(region, pageable));
    }

    @GetMapping("api/my")
    public ApiResponse<UserResDTO.userRes> my(
    ){
        BaseSuccessCode code = UserSuccessCode.USER_FOUND;
        return ApiResponse.onSuccess(code, userService.user(1234L));
    }

    @PostMapping("auth/signup")
    public ApiResponse<UserResDTO.signUpRes> signUp(
            @RequestBody
            UserReqDTO.signUpReq request
    ){
        BaseSuccessCode code = UserSuccessCode.USER_CREATED;
        return ApiResponse.onSuccess(code, userService.signUp(request));
    }
}
