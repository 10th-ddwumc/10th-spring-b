package com.ddwuumc.week4.user.entity.inquiry;

import com.ddwuumc.week4.global.common.BaseEntity;
import com.ddwuumc.week4.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 50, nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryType type;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "inquiry")
    private final List<InquiryPhoto> inquiryPhotos = new ArrayList<>();

    public void addInquiryPhotos(InquiryPhoto inquiryPhoto) {
        this.inquiryPhotos.add(inquiryPhoto);
    }
}
