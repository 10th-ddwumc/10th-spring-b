package com.ddwuumc.week4.mission.dto;

import com.ddwuumc.week4.mission.entity.Mission;
import com.ddwuumc.week4.mission.entity.UserMission;
import com.ddwuumc.week4.store.entity.Store;

import static com.ddwuumc.week4.mission.dto.MissionResponseDto.*;

public class UserMissionConverter {
    public static MissionItem convert(UserMission um) {
        return new MissionItem(
                um.getStatus(),
                convertToMissionInfo(um.getMission()),
                convertToStoreInfo(um.getMission().getStore())
        );
    }

    private static MissionInfo convertToMissionInfo(Mission mission) {
        return new MissionInfo(
                mission.getId(),
                mission.getPeriod(),
                mission.getPrice(),
                mission.getPoint()
        );
    }

    private static StoreInfo convertToStoreInfo(Store store) {
        return new StoreInfo(
                store.getId(),
                store.getName(),
                store.getFood().getName()
        );
    }
}
