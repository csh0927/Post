package com.example.post.controller;

import com.example.post.dto.PostIdResponse;
import com.example.post.dto.PostRequest;
import com.example.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostIdResponse savePost(@RequestBody @Valid PostRequest request){
        return postService.savePost(request);
    }

    @PutMapping
    public PostIdResponse updatePost(@RequestBody @Valid PostRequest request){
        return postService.updatePost(request);
    }
}
