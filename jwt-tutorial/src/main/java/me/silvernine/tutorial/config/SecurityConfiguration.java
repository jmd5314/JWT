package me.silvernine.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //HttpServletRequest 를 사용하는 요청들에 대한 접근 제한을 설정
                .requestMatchers(new AntPathRequestMatcher("/api/hello")).permitAll() //apt/hello 에 대한 접근은 인증없이
                .anyRequest().authenticated(); //나머지 요청은 인증

        return http.build();
    }
}
