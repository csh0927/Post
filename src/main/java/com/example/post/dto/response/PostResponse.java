package com.example.post.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private final String username;
    private final String title;
    private final String content;

    @Builder
    public PostResponse(String username, String title, String content){
        this.username = username;
        this.title = title;
        this.content = content;
    }

}
