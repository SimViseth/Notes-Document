package com.example.document.feature.dao;

import com.example.document.core.BaseDBDao;
import com.example.document.feature.entity.Document;
import com.example.document.feature.repository.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentDao extends BaseDBDao<Document, Integer> {
    public DocumentDao(DocumentRepository documentRepository) {
        super(documentRepository);
    }
}
