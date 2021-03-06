package com.me.book.springboot.web;

import com.me.book.springboot.config.auth.LoginUser;
import com.me.book.springboot.config.auth.dto.SessionUser;
import com.me.book.springboot.domain.posts.PostsService;
import com.me.book.springboot.domain.user.User;
import com.me.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { //Model - 서버 템플릿 안에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());

        //CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성. 로그인 성공 시 값을 가져온다.
        // SessionUser user = (SessionUser)httpSession.getAttribute("user"); = @LoginUser로 대체
        if(user != null) { //세션에 저장된 값이 있을 때만 model에 userName으로 등록.
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
