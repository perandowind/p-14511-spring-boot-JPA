package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**내가 만든 스프링을 빈에 등록하는 방법: Componet 어노테이션 붙이기*/
@Service // @Component랑 같은 기능, 가독성을 위해 Service 사용
@RequiredArgsConstructor
public class PostService {

    /** 객체 주입은 "필드 주입, 생성자 주입(권장)"이 있음 */
    @Autowired //필드주입
    private final PostRepository postRepository; // 생성자 주입 (final 과 애너테이션으로)

    // 생성자 주입
//    public PostService(PostRepository postRepository) {}

    public Post write(String title, String content) {

        Post post = new Post(title, content);
        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Post post, String newTitle, String newContent) {
        //더티체킹으로 변화를 감지해서 반영해줌 (return postRepository.save(post) 와 동일한 기능)
        post.setTitle(newTitle);
        post.setContent(newContent);

        return post;
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
