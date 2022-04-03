package com.example.cloudstorage.services.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;
import java.util.List;

@Entity
@IdClass(value = FileJournalIdClass.class)
public class FileJournaling {

    @Id
    private Long journalId;
    @Id
    private Long namespaceId;

    private String relativePath;

    private List<String> blockList; //SHA-HASH KEY-1, KEY-2, KEY-3

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public Long getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(Long namespaceId) {
        this.namespaceId = namespaceId;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public List<String> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<String> blockList) {
        this.blockList = blockList;
    }
}

class FileJournalIdClass implements Serializable {
    private Long journalId;
    private Long namespaceId;

    public FileJournalIdClass(Long journalId, Long namespaceId) {
        this.journalId = journalId;
        this.namespaceId = namespaceId;
    }
}
