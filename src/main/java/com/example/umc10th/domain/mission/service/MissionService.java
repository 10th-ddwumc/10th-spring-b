package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    public MissionResDTO.missionRes missions(String status) {
        List<UserMission> missions = List.of(

        );
        return MissionConverter.toMissionRes(missions);
    }

    public MissionResDTO.missionCompleteRes completeMission(Long missionId){
        return MissionConverter.toMissionCompleteRes(missionId);
    }
}
