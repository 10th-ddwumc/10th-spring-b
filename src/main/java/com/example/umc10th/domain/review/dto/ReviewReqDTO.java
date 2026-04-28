package com.example.umc10th.domain.review.dto;

import java.util.List;

public class ReviewReqDTO {
    public record reviewReq(
            Integer storeId,
            String content,
            List<Photo> photos,
            Integer star
    ){}

    public record Photo(
            String photoUri
    ){}
}
