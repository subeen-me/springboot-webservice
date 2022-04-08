package com.me.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 자동으로 설정. 프로젝트 최상단에 위치
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
