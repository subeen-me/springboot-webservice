package com.me.book.springboot.config.auth.dto;

import com.me.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 세션에 사용자 정보를 저장하기 위한 Dto 클래스. 직렬화 기능을 가진 세션 Dto
 * 인증된 사용자 정보만 필요하므로 name, email, picture 이외의 정보는 필요하지 않는다.
 */

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser() {

    }

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}