package com.example.document.feature.controller;

import com.example.document.app.BaseResponse;
import com.example.document.feature.dto.request.DocumentRequest;
import com.example.document.feature.dto.response.DocumentResponse;
import com.example.document.feature.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/document")
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("create")
    public BaseResponse<DocumentResponse> createDocument(@RequestBody DocumentRequest documentRequest) {
        BaseResponse<DocumentResponse> documentResponse = documentService.createDocument(documentRequest);
        return documentResponse;
    }
}
