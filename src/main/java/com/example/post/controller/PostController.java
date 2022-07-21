package com.example.post.controller;

import com.example.post.dto.response.PostIdResponse;
import com.example.post.dto.response.PostListResponse;
import com.example.post.dto.request.PostRequest;
import com.example.post.dto.response.PostResponse;
import com.example.post.entity.Post;
import com.example.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostIdResponse savePost(@RequestBody @Valid PostRequest request){
        return postService.savePost(request);
    }
    @PutMapping
    public PostIdResponse updatePost(@RequestBody @Valid Post post, PostRequest request){
        return postService.updatePost(post, request);
    }
    @PostMapping
    public PostListResponse showPostList(Pageable page){
        return postService.showPostList(page);
    }
    @GetMapping("/post{id}")
    public PostResponse showPost(@PathVariable Long id){
        return postService.showPost(id);
    }
    @DeleteMapping
    public void deletePost(@RequestBody @Valid Post post, PostRequest request){
        postService.deletePost(post, request);
    }
}
