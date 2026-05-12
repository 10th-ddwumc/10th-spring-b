package com.example.umc10th.domain.member.controller;

import com.example.umc10th.domain.member.dto.request.MemberReqDTO;
import com.example.umc10th.domain.member.dto.response.MemberResDTO;
import com.example.umc10th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc10th.domain.member.service.MemberService;
import com.example.umc10th.domain.review.dto.response.ReviewResDTO;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/my-page")
    public ApiResponse<MemberResDTO.MyPageResDTO> getMyPage(
            @RequestBody @Valid MemberReqDTO.MemberIdReqDTO request) {
        return ApiResponse.onSuccess(MemberSuccessCode.GET_MY_PAGE, memberService.getMyPage(request.getMemberId()));
    }

    @GetMapping("/members/reviews")
    public ApiResponse<ReviewResDTO.MyReviewListResDTO> getMyReviews(
            @RequestBody @Valid MemberReqDTO.MemberIdReqDTO request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ApiResponse.onSuccess(MemberSuccessCode.GET_MY_REVIEWS, memberService.getMyReviews(request.getMemberId(), page, size));
    }

//    @PostMapping("/sign-up")
//    public ApiResponse<Void> signUp(
//            @RequestBody MemberReqDTO.SignUpReqDTO request
//    ){
//        BaseSuccessCode code = GeneralSuccessCode.OK;
//        return ApiResponse.onSuccess(code, memberService.signUp(request));
//    }
}
