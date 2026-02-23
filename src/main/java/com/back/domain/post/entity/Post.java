package com.back.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String title;

    /**
     * 기본값은 varchar() 타입, 근데 내가 직접 타입 TEXT로 지정함
     */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    // Entity가 붙은 클래스는 기본 생성자 필수
    //public Post() {}

    public Post(String title, String content) {
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
        this.title = title;
        this.content = content;
    }
}
