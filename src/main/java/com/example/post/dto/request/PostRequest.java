package com.example.post.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PostRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String username;

    @NotBlank
    private Long id;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @Builder
    public PostRequest(String title, String content, String username, Long id, String password){
        this.title = title;
        this.content = content;
        this.username = username;
        this.id = id;
        this.password = password;
    }
}
