package com.example.umcdongdong2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

public class UserNotificationsResDTO {

    @Builder
    public record Notice(
            Long noticeId,
            @JsonProperty("time_noticed") String timeNoticed,
            String content,
            String title
    ) {}

    @Builder
    public record UserNotificationsResponse(
            List<Notice> notices,
            Integer page,
            Integer size,
            Long totalElements,
            Integer totalPages,
            Boolean hasNext
    ) {}
}
