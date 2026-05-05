package com.ddwuumc.week4.mission.service;

import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionItem;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionList;
import com.ddwuumc.week4.mission.dto.UserMissionConverter;
import com.ddwuumc.week4.mission.entity.MissionStatus;
import com.ddwuumc.week4.mission.entity.UserMission;
import com.ddwuumc.week4.mission.repository.MissionRepository;
import com.ddwuumc.week4.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    public MissionList getMissions(MissionStatus status, Long page) {
        // TODO: user id는 하드코딩함
        Pageable pageable = PageRequest.of(0, 10);
        List<UserMission> userMissionList = userMissionRepository.findByMissionPage(0L, status, page, pageable);

        List<MissionItem> missions = userMissionList.stream()
                .map(UserMissionConverter::convert)
                .toList();

        Integer successCount = userMissionRepository.countByStatusAndUserId(MissionStatus.SUCCESS, 0L);

        return new MissionList(missions, successCount);
    }

    public Long successMission(Long id) {
        // 별도의 body를 받지 않고 MissionStatus를 SUCCESS로 변경

        return 100L; // 수정한 미션 번호
    }
}
