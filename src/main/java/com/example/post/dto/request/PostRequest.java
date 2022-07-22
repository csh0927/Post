package com.example.post.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PostRequest {
    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    @Size(max = 1000)
    private String content;

    @NotBlank
    @Size(max = 20)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @Builder
    public PostRequest(String title, String content, String userName, String password){
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
    }
}
