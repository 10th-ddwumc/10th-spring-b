package com.ddwuumc.week4.global.common;

import java.util.List;

public class PageDto {
    public record Pagenation<T>(
        List<T> data,
        Integer pageNumber,
        Integer pageSize,
        Long totalElements,
        Integer totalPage
    ) {}
}
