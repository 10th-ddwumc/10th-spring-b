package com.ddwuumc.week4.global.common;

import java.util.List;

public class PageDto {
    public record Offset<T>(
            List<T> data,
            Integer pageNumber,
            Integer pageSize,
            Long totalElements,
            Integer totalPage
    ) {}

    public record Cursor<T>(
            List<T> data,
            Integer pageSize,
            Long cursor,
            Boolean hasNext
    ) {}
}
