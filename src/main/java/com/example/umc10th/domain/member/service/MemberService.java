package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.dto.request.MemberReqDTO;
import com.example.umc10th.domain.member.dto.response.MemberResDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public MemberResDTO.HomeResDTO getHome(String region, int page, int size) {
    }

    public Void signUp(MemberReqDTO.SignUpReqDTO request) {
    }
}
