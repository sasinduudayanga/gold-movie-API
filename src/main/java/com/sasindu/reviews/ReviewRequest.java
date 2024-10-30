package com.sasindu.reviews;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewRequest {
    private String imdbId;
    private String body;
}
