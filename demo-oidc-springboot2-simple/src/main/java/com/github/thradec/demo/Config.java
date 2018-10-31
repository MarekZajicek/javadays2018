package com.github.thradec.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login()
                .loginPage("/oauth2/authorization/demo")
                .and()
            .authorizeRequests()
                .anyRequest()
                    .authenticated();
    }

}