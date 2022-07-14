package com.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 20, nullable = false)
    private String username;

    @Column
    @Size(min = 6, max = 20)
    private String password;

    public Post update(String title, String content){
        this.title = title;
        this.content = content;
        return this;
    }
}
