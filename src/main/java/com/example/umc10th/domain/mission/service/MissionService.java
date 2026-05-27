package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.member.entity.mapping.MemberMission;
import com.example.umc10th.domain.member.repository.MemberMissionRepository;
import com.example.umc10th.domain.mission.dto.request.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.response.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.mission.exception.MissionException;
import com.example.umc10th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc10th.domain.store.entity.Store;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class MissionService {
    private final MemberMissionRepository memberMissionRepository;

    /**
     * 내가 진행중 / 진행 완료한 미션 목록 조회 (페이징)
     */
    @Transactional(readOnly = true)
    public MissionResDTO.MissionListResDTO getMyMissions(Long memberId, MissionStatus status, Pageable pageable) {
        Page<MemberMission> memberMissions =
                memberMissionRepository.findByMemberIdAndStatus(memberId, status.name(), pageable);

        Page<MissionResDTO.MissionDTO> missionDTOs = memberMissions.map(mm -> {
            Mission mission = mm.getMission();
            Store store = mission.getStore();

            long daysLeft = mission.getEndAt() != null
                    ? ChronoUnit.DAYS.between(LocalDateTime.now(), mission.getEndAt())
                    : 0;

            return MissionResDTO.MissionDTO.builder()
                    .memberMissionId(mm.getId())
                    .status(mm.getStatus())
                    .missionName(mission.getMissionName())
                    .storeName(store.getStoreName())
                    .storeType(store.getStoreType())
                    .point(mission.getPoint())
                    .daysLeft((int) daysLeft)
                    .endAt(mission.getEndAt())
                    .build();
        });

        return MissionResDTO.MissionListResDTO.builder()
                .missions(missionDTOs)
                .build();
    }


    /**
     * 미션 상태 변경 (진행중 → 진행완료)
     */
    @Transactional
    public void updateMissionStatus(Long memberMissionId, MissionStatus newStatus) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MEMBER_MISSION_NOT_FOUND));

        if (MissionStatus.COMPLETED.name().equals(memberMission.getStatus())) {
            throw new MissionException(MissionErrorCode.MISSION_ALREADY_COMPLETED);
        }

        memberMission.updateStatus(newStatus.name());
    }
}
