package com.me.book.springboot.config.auth;

import com.me.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점. authorizeRequests가 선언되어야만 antMatchers 옵션 사용가능.
                    .antMatchers("/", "/css/**", "/images/**",
                            "/js/**", "/h2-console/**").permitAll() //권한 관리 대상을 지정하는 옵션. 지정된 URL들은 permitAll()옵션을 통해 전체 열람 권한 주었다.
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //이 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 한다.
                    .anyRequest().authenticated() //설정된 값들 이외 나머지 URL은 모두 인증된 사용자들에게만 허용(로그인한 사용자).
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 성공 시 이 주소로 이동.
                .and()
                    .oauth2Login() //OAuth2 로그인 기능에 대한 여러 설정의 진입점.
                        .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당.
                        .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치를 징행할 UserService 인터페이스의 구현체를 등록.
    }
}
