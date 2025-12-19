package com.example.document.external.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkspaceResponse {
    private Integer workspaceId;
    private String workspaceName;
    private Boolean isPrivate;
}
