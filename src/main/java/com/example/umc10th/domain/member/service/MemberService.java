package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.MemberConverter;
import com.example.umc10th.domain.member.dto.MemberReqDTO;
import com.example.umc10th.domain.member.dto.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.MemberErrorCode;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.HomeMission;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.repository.MemberMissionRepository;
import com.example.umc10th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    // 마이페이지 정보 조회 (회원 ID 기반으로 사용자 정보 반환)
    public MemberResDTO.GetInfo getInfo(
            MemberReqDTO.GetInfo dto)
    {
        Long memberId = dto.id();
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));
        return MemberConverter.toGetInfo(member);
    }

    // 회원가입 처리 (신규 회원 생성 로직)
    public MemberResDTO.signUp signUp(MemberReqDTO.signUp dto) {
        return null;
    }

    // 홈 화면 조회 (지역 + 커서 기반 미션 리스트 및 통계 조회)
    public MemberResDTO.home home(
            Long memberId,
            String location,
            Long lastId,
            int pageSize)
    {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 1. 도전 가능한 미션 목록 조회 (커서 기반 페이징 적용)
        List<HomeMission> missions = new ArrayList<>();

        Pageable pageable = PageRequest.of(0, pageSize);

        if (lastId != null) {
            missions = missionRepository.findByLocationWithCursor(memberId, location, lastId, pageable);
        } else {
            missions = missionRepository.findByLocationWithoutCursor(memberId, location, pageable);
        }

        // 2. 선택된 지역의 전체 미션 수 조회
        Integer allMissions = memberMissionRepository.countAllMissionsByLocation(memberId, location);

        // 3. 선택된 지역에서 성공적으로 완료한 미션 수 조회
        Integer successMission = memberMissionRepository.countSuccessMissionsByLocation(memberId, location);

        return MemberConverter.toHome(location, allMissions, successMission, missions);
    }
}
