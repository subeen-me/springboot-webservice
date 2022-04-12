package com.me.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing //JPA Auditing 활성화, JpaConfig 추가하면서 삭제
@SpringBootApplication //스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 자동으로 설정. 프로젝트 최상단에 위치
public class Application {
    public static void main(String[] args) {
        //내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
