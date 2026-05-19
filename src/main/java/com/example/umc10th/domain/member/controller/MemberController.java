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

    @GetMapping("/members/my-page/{memberId}")
    public ApiResponse<MemberResDTO.MyPageResDTO> getMyPage(
            @PathVariable Long memberId) {
        return ApiResponse.onSuccess(MemberSuccessCode.GET_MY_PAGE, memberService.getMyPage(memberId));
    }

    @GetMapping("/members/reviews")
    public ApiResponse<ReviewResDTO.MyReviewCursorListResDTO> getMyReviews(
            @RequestBody @Valid MemberReqDTO.MemberIdReqDTO request,
            @RequestParam(defaultValue = "ID") String sort,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long cursorId,
            @RequestParam(required = false) Float cursorRating
    ) {
        return ApiResponse.onSuccess(MemberSuccessCode.GET_MY_REVIEWS,
                memberService.getMyReviews(request.getMemberId(), sort, size, cursorId, cursorRating));
    }

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.SignUpResDTO> signUp(
            @RequestBody MemberReqDTO.SignUpReqDTO request
    ){
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, memberService.signup(request));
    }
}
