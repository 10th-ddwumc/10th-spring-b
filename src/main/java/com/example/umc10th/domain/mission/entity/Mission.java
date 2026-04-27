package com.example.umc10th.domain.mission.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import com.example.umc10th.domain.mission.enums.Status;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 미션 제목
    private String title;

    // 미션 설명
    private String content;

    // 미션 수행 시 기준 금액 (예: 최소 주문 금액 등)
    private Integer price;

    // 미션 종료일
    private LocalDate endDate;

    // 미션 완료 시 획득 포인트
    private Integer point;

    // 미션 상태 (IN_PROGRESS / SUCCESS / FAIL)
    @Enumerated(EnumType.STRING)
    private Status status;

    // 미션이 속한 가게
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // 최초 생성 시 기본 상태 설정
    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = Status.IN_PROGRESS;
        }
    }
}
