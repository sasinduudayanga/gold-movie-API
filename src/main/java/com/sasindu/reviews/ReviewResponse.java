package com.sasindu.reviews;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ReviewResponse {
    private String body;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;
}
