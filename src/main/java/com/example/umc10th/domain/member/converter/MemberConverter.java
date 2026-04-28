package com.example.umc10th.domain.member.converter;

import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;

import java.lang.reflect.Member;
import java.util.List;


public class MemberConverter {
    public static MemberResDTO.signUpRes toSignUpRes(MemberReqDTO.signUpReq request) {
        return MemberResDTO.signUpRes.builder()
                .memeberId(12345L)
                .name(request.name())
                .build();
    }
    public static MemberResDTO.homeRes toHomeRes(String name, String region, List<UserMission> missions){
        return MemberResDTO.homeRes.builder()
                .name(name)
                .region(region)
                .missions(missions)
                .build();
    }
}
