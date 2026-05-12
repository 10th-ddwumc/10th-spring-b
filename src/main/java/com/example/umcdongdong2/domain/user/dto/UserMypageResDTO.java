package com.example.umcdongdong2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class UserMypageResDTO {

    @Builder
    public record UserMypageResponse(
            Long userId,
            String name,
            String email,
            Integer gender,
            String birth,
            String address,
            @JsonProperty("notice_marketing") Boolean noticeMarketing,
            @JsonProperty("notice_reply_review") Boolean noticeReplyReview,
            @JsonProperty("notice_reply_qna") Boolean noticeReplyQna
    ) {}
}
