package com.github.thradec.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static java.util.stream.Collectors.joining;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NameService nameService;

    @GetMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String name = nameService.name();
            model.addAttribute("name", name != null ? name : authentication.getName());
            model.addAttribute("roles", authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(joining(", ")));
        }
        return "index";
    }

}
