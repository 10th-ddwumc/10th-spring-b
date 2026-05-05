package com.ddwuumc.week4.mission.repository;

import com.ddwuumc.week4.mission.entity.MissionStatus;
import com.ddwuumc.week4.mission.entity.UserMission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    @Query("SELECT um FROM UserMission um " +
            "JOIN FETCH um.mission m " +
            "JOIN FETCH m.store s " +
            "WHERE um.user.id = :userId AND um.id < :page AND um.status = :status " +
            "ORDER BY um.id DESC")
    List<UserMission> findByMissionPage(@Param("userId") Long userId,
                                        @Param("status") MissionStatus status,
                                        @Param("page") Long page,
                                        Pageable pageable);

    @Query("SELECT um FROM UserMission um " +
            "JOIN FETCH um.mission m " +
            "JOIN FETCH m.store s " +
            "JOIN FETCH um.user u " +
            "WHERE um.user.id = :userId AND um.status = 'RUNNING' AND " +
            "s.detailAddress = :detailAddress AND um.id < :page " +
            "ORDER BY um.id DESC")
    List<UserMission> findHomePage(@Param("userId") Long userId,
                                   @Param("detailAddress") String detailAddress,
                                   @Param("page") Long page,
                                   Pageable pageable);

    Integer countByStatusAndUserId(MissionStatus status, Long userId);
}
