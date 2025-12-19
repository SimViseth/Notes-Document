package com.example.document.feature.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "TBL_DOCUMENT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Document {
    @Id
    Integer documentId;

    Integer workspaceId; // foreign key
    String title;
    String content;
    Boolean isPrivate;
    Boolean isDelete;
    Timestamp createdAt;
    Timestamp updatedAt;
}
