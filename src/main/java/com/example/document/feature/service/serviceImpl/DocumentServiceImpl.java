package com.example.document.feature.service.serviceImpl;

import com.example.document.app.BaseResponse;
import com.example.document.core.BaseEntityResponseDto;
import com.example.document.external.WorkspaceClient;
import com.example.document.external.dto.WorkspaceResponse;
import com.example.document.feature.dao.DocumentDao;
import com.example.document.feature.dto.request.DocumentRequest;
import com.example.document.feature.dto.response.DocumentResponse;
import com.example.document.feature.entity.Document;
import com.example.document.feature.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.document.app.AppConstant.*;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    private final WorkspaceClient workspaceClient;
    @Override
    public BaseResponse<DocumentResponse> createDocument(DocumentRequest documentRequest) {

        WorkspaceResponse workspaceResponse = workspaceClient.getWorkspaceById(documentRequest.getWorkspaceId());

        if (workspaceResponse == null) {
            BaseResponse<DocumentResponse> response = new BaseResponse<>();
            response.setCode(NOT_FOUND);
            response.setStatus(FAIL);
            response.setMsgDev("Workspace not found");
            return response;
        }

        Document document = new Document();
        document.setTitle(documentRequest.getTitle());
        document.setContent(documentRequest.getContent());
        document.setIsPrivate(documentRequest.getIsPrivate());
        document.setIsDelete(false);
        document.setWorkspaceId(workspaceResponse.getWorkspaceId());
        document.setCreatedAt(LocalDateTime.now());
        document.setUpdatedAt(LocalDateTime.now());

        BaseEntityResponseDto<Document> daoResponse = documentDao.saveEntity(document);

        DocumentResponse documentResponse = DocumentResponse.builder()
                .title(daoResponse.getEntity().getTitle())
                .content(daoResponse.getEntity().getContent())
                .workspaceId(daoResponse.getEntity().getWorkspaceId())
                .isPrivate(daoResponse.getEntity().getIsPrivate())
                .createdAt(daoResponse.getEntity().getCreatedAt())
                .build();

        BaseResponse<DocumentResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsgDev("Document created successfully");
        baseResponse.setData(documentResponse);

        return baseResponse;
    }
}
