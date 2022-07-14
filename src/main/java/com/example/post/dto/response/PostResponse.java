package com.example.post.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private final String userName;
    private final String title;
    private final String content;

    @Builder
    public PostResponse(String userName, String title, String content){
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

}
