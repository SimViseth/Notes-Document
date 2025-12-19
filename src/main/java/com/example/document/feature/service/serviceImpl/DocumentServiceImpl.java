package com.example.document.feature.service.serviceImpl;

import com.example.document.app.BaseResponse;
import com.example.document.external.dto.WorkspaceResponse;
import com.example.document.feature.dao.DocumentDao;
import com.example.document.feature.dto.request.DocumentRequest;
import com.example.document.feature.dto.response.DocumentResponse;
import com.example.document.feature.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    private final WebClient workspaceClient;
    @Override
    public BaseResponse<DocumentResponse> createDocument(DocumentRequest documentRequest) {
        BaseResponse<WorkspaceResponse> workspaceResponse = workspaceClient.get()
                .uri("/{id}", documentRequest.getWorkspaceId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<WorkspaceResponse>>() {})
                .block();
    }
}
