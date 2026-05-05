package com.example.umc10th.domain.store.entity;

import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name", length = 255)
    private String storeName;

    @Column(name = "store_type", length = 255)
    private String storeType;

    @Column(name = "address", length = 255)
    private String address;

    // 연관관계
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StorePhoto> storePhotoList = new ArrayList<>();
}
