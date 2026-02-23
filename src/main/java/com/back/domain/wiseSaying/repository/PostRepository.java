package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**@id로 지정된 PK의 타입을 기입해야함 int id 이므로 <앤터티 클래스, Integer>*/
public interface PostRepository extends JpaRepository<Post, Integer> {
    boolean existsAllByContent(String content);
}
