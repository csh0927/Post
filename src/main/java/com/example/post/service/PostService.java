package com.example.post.service;

import com.example.post.dto.PostRequest;
import com.example.post.dto.PostIdResponse;
import com.example.post.entity.Post;
import com.example.post.entity.PostRepository;
import com.example.post.exception.ConflictException;
import com.example.post.exception.NotFoundException;
import lombok.Builder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Builder
@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    //게시글 업로드
    public PostIdResponse savePost(PostRequest request){
        return new PostIdResponse(
                postRepository.save(
                        Post.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        ).getId());
    }
    //게시글 수정
    public PostIdResponse updatePost(PostRequest request){
        Post post = postRepository.findById(request.getId())
                .orElseThrow(NotFoundException::new);

        if(passwordEncoder.matches(post.getPassword(), request.getPassword())){
            throw new ConflictException();
        }

        return new PostIdResponse(post.update(request.getTitle(), request.getContent()).getId());
    }
}
