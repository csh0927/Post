package com.example.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class PostResponse {
    private final String username;
    private final String title;
    private final String content;
}
