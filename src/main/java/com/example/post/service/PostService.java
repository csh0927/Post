package com.example.post.service;

import com.example.post.dto.response.PostListResponse;
import com.example.post.dto.request.PostRequest;
import com.example.post.dto.response.PostIdResponse;
import com.example.post.dto.response.PostResponse;
import com.example.post.entity.Post;
import com.example.post.entity.PostRepository;
import com.example.post.exception.ConflictException;
import com.example.post.exception.NotFoundException;
import lombok.Builder;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Transactional
@RequiredArgsConstructor
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

    //게시글 리스트 보기(페이징 처리)
    public PostListResponse showPostList(Pageable page){
        List<Post> PostList = postRepository.findAllByOrderByIdDesc(page);
        List<PostListResponse.PostResponse> postResponse = new ArrayList<>();

        for (Post post : PostList) {
            postResponse.add(
                    PostListResponse.PostResponse.builder()
                            .title(post.getTitle())
                            .content(post.getContent())
                            .build()
            );
        }
            return new PostListResponse(postResponse);

        }

        //게시글 보기
        public PostResponse showPost(Long id){
            Post post = postRepository.findById(id)
                    .orElseThrow(NotFoundException :: new);

            return PostResponse.builder()
                    .username(post.getUsername())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .build();
        }
}
