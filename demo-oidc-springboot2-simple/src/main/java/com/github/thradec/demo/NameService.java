package com.github.thradec.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class NameService {

    private final WebClient webClient;

    public String name() {
        try {
            return webClient
                    .get()
                    .uri("http://demo.local:8092/api/name")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            return null;
        }
    }

}