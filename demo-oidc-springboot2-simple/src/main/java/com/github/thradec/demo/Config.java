package com.github.thradec.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;

import java.util.List;

import static java.util.stream.Collectors.toSet;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login()
                .loginPage("/oauth2/authorization/demo")
                .userInfoEndpoint()
                    .userAuthoritiesMapper(userAuthoritiesMapper())
                    .and()
                .and()
            .authorizeRequests()
                .anyRequest()
                    .authenticated();
    }

    private GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            for (GrantedAuthority authority : authorities) {
                if (authority instanceof OidcUserAuthority) {
                    OidcIdToken token = ((OidcUserAuthority)authority).getIdToken();
                    List<String> roles = token.getClaimAsStringList("roles");
                    if (roles != null) {
                        return roles
                                .stream()
                                .map(String::toUpperCase)
                                .map(r -> "ROLE_" + r)
                                .map(SimpleGrantedAuthority::new)
                                .collect(toSet());
                    }
                }
            }
            return authorities;
        };
    }

}