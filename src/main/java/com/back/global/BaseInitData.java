package com.back.global;

import com.back.domain.post.repository.PostRepository;
import com.back.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {
            work1();
            work2();
        };
    }

    void work1() {

        try{
        if(postRepository.count() > 0) {
            return;
        }

        // 어떤 기능을 테스트 데이터가 2개인 것을 가정하고 개발
        postService.write("제목1", "내용1");

        if(true){
            throw new RuntimeException("테스트 예외");
        }

        postService.write("제목2", "내용2");

    }catch(Exception e){
            System.out.println("예외 발생 : " + e.getMessage());}
    }

    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }

}
