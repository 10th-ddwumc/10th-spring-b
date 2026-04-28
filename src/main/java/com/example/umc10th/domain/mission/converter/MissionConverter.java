package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;

import java.util.List;

public class MissionConverter {
    public static MissionResDTO.missionRes toMissionRes(List<UserMission> missions){
        return MissionResDTO.missionRes.builder()
                .missions(missions)
                .build();
    }

    public static MissionResDTO.missionCompleteRes toMissionCompleteRes(Long missionId) {
        return MissionResDTO.missionCompleteRes.builder()
                .missionId(missionId)
                .build();
    }
}
