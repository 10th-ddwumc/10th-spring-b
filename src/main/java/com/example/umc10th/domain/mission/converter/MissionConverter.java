package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;

public class MissionConverter {

    // 미션 성공/실패 처리 응답 DTO로 변환
    public static MissionResDTO.Success toSuccess(Mission mission) {
        return MissionResDTO.Success.builder()
                .id(mission.getId())
                .status(mission.getStatus())
                .build();
    }

    // 미션 조회 응답 DTO로 변환
    public static MissionResDTO.GetMissions toGetMissions(Mission mission) {
        return MissionResDTO.GetMissions.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .content(mission.getContent())
                .point(mission.getPoint())
                .status(mission.getStatus())
                .build();
    }
}
