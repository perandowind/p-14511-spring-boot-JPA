package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;

    @Bean
    ApplicationRunner baseInitDataRunner() {
        return args -> {
            self.work1();
            self.work2();
            self.work3();
        };
    }
    @Transactional
    void work1() {

        if (postService.count() > 0) {
            return;
        }

        // 어떤 기능을 테스트 데이터가 2개인 것을 가정하고 개발
        postService.write("제목1", "내용1");

//        if (true) {
//            throw new RuntimeException("테스트 예외");
//        }

        postService.write("제목2", "내용2");
    }


    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }

    @Transactional
    void work3() {
        Post post = postService.findById(1).get();

        postService.modify(post, "제목1-1", "내용1-1");
    }

/*
    @Transactional
    void work4() {
        Post post1 = postService.findById(1).get();
        Post post2 = postService.findById(2).get();

        postService.delete(post1);
        //if(true) throw new RuntimeException();
        postService.delete(post2);
    }
*/

}
