package com.example.document.feature.controller;

import com.example.document.feature.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/document")
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;


}
