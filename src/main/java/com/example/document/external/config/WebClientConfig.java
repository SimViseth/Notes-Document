package com.example.document.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient workspaceWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8080/api/v1/workspace")
                .build();
    }
}

