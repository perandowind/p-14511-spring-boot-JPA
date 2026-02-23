package com.back.global;

import com.back.domain.wiseSaying.entity.Post;
import com.back.domain.wiseSaying.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {

            if (postRepository.count() > 0) {
                return;
            }

            System.out.println("초기 데이터를 로딩합니다.");

            /**아무것도 구현안한 것 같지만, 구현이 되어있음을 확인 가능 JPA Repository 것을 구현*/

            Post post1 = new Post("제목1", "내용1");
            postRepository.save(post1);
        };
    }

}
