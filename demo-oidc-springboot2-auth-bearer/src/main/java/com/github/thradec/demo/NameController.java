package com.github.thradec.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/api/name")
    public String name(@AuthenticationPrincipal Jwt jwt) {
        String givenName = jwt.getClaimAsString("given_name");
        String familyName = jwt.getClaimAsString("family_name");
        String preferredUsername = jwt.getClaimAsString("preferred_username");
        return givenName + " " + familyName + " (" + preferredUsername + ")";
    }

}