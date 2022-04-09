package com.me.book.springboot.web.dto;

import com.me.book.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsUpdateRequestDto {

    private String title;
    private String content;

    public PostsUpdateRequestDto(Posts entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
