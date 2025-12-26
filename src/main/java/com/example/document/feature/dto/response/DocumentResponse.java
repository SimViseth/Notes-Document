package com.example.document.feature.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class DocumentResponse {
    private Integer documentId;
    private Integer workspaceId;
    private String title;
    private String content;
    private Boolean isPrivate;
    private LocalDateTime createdAt;
}
