package com.example.umc10th.domain.member.controller;


import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc10th.domain.member.service.MemberService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 마이페이지 정보 조회 API (사용자 기본 정보 반환)
    @PostMapping("/api/v1/users/me")
    public ApiResponse<MemberResDTO.GetInfo> getInfo(
            @RequestBody MemberReqDTO.GetInfo dto
    ) {
        BaseSuccessCode code = MemberSuccessCode.OK;
        return ApiResponse.onSuccess(code, memberService.getInfo(dto));
    }

    // 회원가입 API (신규 사용자 생성)
    @PostMapping("/auth/users/signup")
    public ApiResponse<MemberResDTO.signUp> signUp(
            @RequestBody MemberReqDTO.signUp dto
    ) {
        BaseSuccessCode code = MemberSuccessCode.OK;
        return ApiResponse.onSuccess(code, memberService.signUp(dto));
    }

    // 홈 화면 조회 API (지역 기반 미션 및 정보 페이징 조회)
    @GetMapping("/api/{memberId}/home")
    public ApiResponse<MemberResDTO.home> home(
            @PathVariable("memberId") Long memberId,
            @RequestParam("location") String location,
            @RequestParam(required = false) Long lastId, // 커서 기반 페이징을 위한 마지막 미션 ID
            @RequestParam(defaultValue = "10") int pageSize // 한 번에 조회할 미션 개수

    ) {
        BaseSuccessCode code = MemberSuccessCode.SUCCESS_HOME;
        return ApiResponse.onSuccess(code, memberService.home(memberId, location, lastId, pageSize));
    }
}
