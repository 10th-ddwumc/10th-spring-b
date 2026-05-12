package com.example.umc10th.domain.mission.converter;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MissionConverter {
    public static MissionResDTO.GetMission toGetMission(
            List<UserMission> userMissions
    ){
        return MissionResDTO.GetMission.builder()
                .missions(userMissions.stream()
                        .map(MissionConverter::toMission)
                        .toList())
                .build();
    }

    public static MissionResDTO.Mission toMission(UserMission userMission) {
        Mission mission = userMission.getMission();

        return new MissionResDTO.Mission(
                mission.getStore().getName(),
                mission.getStore().getType(),
                calculateDday(mission),
                mission.getName(),
                mission.getPoint(),
                userMission.getIsComplete()
        );
    }

    private static Integer calculateDday(Mission mission) {
        return Math.toIntExact(ChronoUnit.DAYS.between(LocalDate.now(), mission.getDday()));
    }

    public static MissionResDTO.missionCompleteRes toMissionCompleteRes(Long missionId) {
        return MissionResDTO.missionCompleteRes.builder()
                .missionId(missionId)
                .build();
    }


    public static <T> MissionResDTO.Pagination<T> toPagination(
            List<T> data,
            Integer pageNumber,
            Integer pageSize
    ) {
        return MissionResDTO.Pagination.<T>builder()
                .data(data)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .build();
    }
}
