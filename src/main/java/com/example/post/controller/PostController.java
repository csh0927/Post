package com.example.post.controller;

import com.example.post.dto.response.PostIdResponse;
import com.example.post.dto.response.PostListResponse;
import com.example.post.dto.request.PostRequest;
import com.example.post.dto.response.PostResponse;
import com.example.post.entity.Post;
import com.example.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;

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
    @PostMapping
    public PostListResponse showPostList(Pageable page){
        return postService.showPostList(page);
    }
    @GetMapping("/post{id}")
    public PostResponse showPost(@PathVariable Long id){
        return postService.showPost(id);
    }
}
