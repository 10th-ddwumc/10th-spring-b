package com.ddwuumc.week4.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 100)
    private String detailAddress;

    private Integer owner_number;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
}
