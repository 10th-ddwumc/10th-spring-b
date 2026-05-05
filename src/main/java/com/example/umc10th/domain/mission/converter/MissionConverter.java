package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;

import java.util.List;

public class MissionConverter {
    public static MissionResDTO.missionRes toMissionRes(List<UserMission> missions){
        return MissionResDTO.missionRes.builder()
                .build();
    }

    public static MissionResDTO.missionCompleteRes toMissionCompleteRes(Long missionId) {
        return MissionResDTO.missionCompleteRes.builder()
                .missionId(missionId)
                .build();
    }

    public static <T> MissionResDTO.PageResDTO<T> toPageRes(Page<T> page) {
        return MissionResDTO.PageResDTO.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }
}
