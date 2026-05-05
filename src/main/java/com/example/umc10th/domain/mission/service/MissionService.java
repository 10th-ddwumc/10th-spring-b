package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.member.enums.FoodType;
import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    public MissionResDTO.PageResDTO<MissionResDTO.missionRes> missions(Long userId, Pageable pageable) {
        Page<MissionResDTO.missionRes> page = new PageImpl<>(List.of(), pageable, 0);
        return MissionConverter.toPageRes(page);
    }

    public MissionResDTO.missionCompleteRes completeMission(Long missionId){
        return MissionConverter.toMissionCompleteRes(missionId);
    }
}
