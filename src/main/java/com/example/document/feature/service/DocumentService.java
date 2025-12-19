package com.example.document.feature.service;


import com.example.document.app.BaseResponse;
import com.example.document.feature.dto.request.DocumentRequest;
import com.example.document.feature.dto.response.DocumentResponse;

public interface DocumentService {
    BaseResponse<DocumentResponse> createDocument(DocumentRequest documentRequest);
}
