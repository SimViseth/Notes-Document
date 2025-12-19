package com.example.document.feature.service.serviceImpl;

import com.example.document.app.BaseResponse;
import com.example.document.feature.dao.DocumentDao;
import com.example.document.feature.dto.request.DocumentRequest;
import com.example.document.feature.dto.response.DocumentResponse;
import com.example.document.feature.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    @Override
    public BaseResponse<DocumentResponse> createDocument(DocumentRequest documentRequest) {
        return null;
    }
}
