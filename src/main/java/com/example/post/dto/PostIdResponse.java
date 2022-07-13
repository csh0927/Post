package com.example.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class PostIdResponse {
    @NotNull
    private Long id;
}
