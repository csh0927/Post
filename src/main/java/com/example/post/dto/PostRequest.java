package com.example.post.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
public class PostRequest {
    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String username;

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;
}
