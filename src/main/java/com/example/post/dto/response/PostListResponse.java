package com.example.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponse {

    private final List<PostResponse> postResponse;

    @Getter
    public class PostResponse{

        private final String title;
        private final String content;

        @Builder
        public PostResponse(String title, String content){
            this.title = title;
            this.content = content;
        }
    }

}
