package com.equadesign.loginPage.config;

import com.equadesign.loginPage.security.PasswordEncoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .authorizeRequests(authorize -> {
                    authorize
                            .mvcMatchers("/h2-console/**").permitAll()
                            .mvcMatchers( "/webjars/**", "/resources/**").permitAll();
                })
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login")
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**");

        http.headers().frameOptions().sameOrigin();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderService.createDelegatingPasswordEncoder();
    }

}
