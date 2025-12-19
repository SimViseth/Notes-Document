package com.example.document.feature.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentRequest {
    private Integer workspaceId;
    private String title;
    private String content;
    private Boolean isPrivate;
}
