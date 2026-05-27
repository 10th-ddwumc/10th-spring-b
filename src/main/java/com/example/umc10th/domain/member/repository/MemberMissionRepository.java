package com.example.umc10th.domain.member.repository;

import com.example.umc10th.domain.member.entity.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    // 내 미션 목록
    @Query("SELECT mm FROM MemberMission mm WHERE mm.member.id = :memberId AND mm.status = :status")
    Page<MemberMission> findByMemberIdAndStatus(
            @Param("memberId") Long memberId,
            @Param("status") String status,
            Pageable pageable
    );
    // 홈 화면
    long countByMemberIdAndStatus(Long memberId, String status);
}
