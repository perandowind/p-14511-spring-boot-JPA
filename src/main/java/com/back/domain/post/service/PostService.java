package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**내가 만든 스프링을 빈에 등록하는 방법: Componet 어노테이션 붙이기*/
@Component
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post write(String title, String content) {

        Post post = new Post(title, content);
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public long count() {
        return postRepository.count();
    }
}
