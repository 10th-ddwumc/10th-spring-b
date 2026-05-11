package com.ddwuumc.week4.mission.repository;

import com.ddwuumc.week4.mission.entity.MissionStatus;
import com.ddwuumc.week4.mission.entity.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    @Query("SELECT um FROM UserMission um " +
            "JOIN FETCH um.mission m " +
            "JOIN FETCH m.store s " +
            "WHERE um.user.id = :userId AND um.status = :status " +
            "ORDER BY um.id DESC")
    Page<UserMission> findByMissionPage(@Param("userId") Long userId,
                                        @Param("status") MissionStatus status,
                                        Pageable pageable);

    @Query("SELECT um FROM UserMission um " +
            "JOIN FETCH um.mission m " +
            "JOIN FETCH m.store s " +
            "JOIN FETCH um.user u " +
            "WHERE um.user.id = :userId AND um.status = 'RUNNING' AND s.detailAddress = :detailAddress " +
            "ORDER BY um.id DESC")
    Page<UserMission> findHomePage(@Param("userId") Long userId,
                                   @Param("detailAddress") String detailAddress,
                                   Pageable pageable);
}
