package com.back.domain.post.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Setter
@Getter
 // 수정이 일어날때마다 modifyDate를 수정해줌
public class Post extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String title;

    /**기본값은 varchar() 타입, 근데 내가 직접 타입 TEXT로 지정함*/
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    // Entity가 붙은 클래스는 기본 생성자 필수
    //public Post() {}

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
