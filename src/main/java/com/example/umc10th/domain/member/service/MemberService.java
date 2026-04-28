package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public MemberResDTO.signUpRes signUp(
            MemberReqDTO.signUpReq dto
    ){
        return MemberConverter.toSignUpRes(dto);
    }

    public MemberResDTO.homeRes home(String region) {
        String name = "홍길동";
        List<UserMission> missions = List.of(

        );
        return MemberConverter.toHomeRes(name, region, missions);
    }
}
