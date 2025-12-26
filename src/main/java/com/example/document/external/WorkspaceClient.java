package com.example.document.external;

import com.example.document.app.BaseResponse;
import com.example.document.external.dto.WorkspaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WorkspaceClient {
    private final WebClient workspaceWebClient;

    public WorkspaceResponse getWorkspaceById(Integer workspaceId) {
        return workspaceWebClient.get()
                .uri("/{id}", workspaceId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Workspace not found")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Workspace service error")))
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<WorkspaceResponse>>() {})
                .map(BaseResponse::getData)
                .block();
    }
}
