package com.example.umcdongdong2.domain.user.entity;


import com.example.umcdongdong2.domain.user.entity.mapping.FoodTaste;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "food")
    private List<FoodTaste> foodTasteList = new ArrayList<>();
}
