package com.example.umc10th.domain.member.controller;

import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.service.MemberService;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/home")
    public ApiResponse<MemberResDTO.homeRes> home(
            @RequestParam String region
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, memberService.home(region));
    }

    @PostMapping("/signup")
    public ApiResponse<MemberResDTO.signUpRes> signUp(
            @RequestBody
            MemberReqDTO.signUpReq request
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, memberService.signUp(request));
    }
}
