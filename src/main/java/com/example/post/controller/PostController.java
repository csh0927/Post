package com.example.post.controller;

import com.example.post.dto.PostIdResponse;
import com.example.post.dto.PostRequest;
import com.example.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostIdResponse postSave(@RequestBody @Valid PostRequest request){
        return postService.postSave(request);
    }
}
