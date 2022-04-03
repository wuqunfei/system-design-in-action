package com.example.cloudstorage.services;

import com.example.cloudstorage.services.models.FileJournaling;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Service
public class FileStorageService {

    public List<FileJournaling> getBlocksById(Long namespaceId, List<Long> journalIds) {
        return Collections.emptyList();
    }
    public FileJournaling uploadFile(Long namespaceId, String relativePath, List<String> blockList){
        FileJournaling file = new FileJournaling();
        file.setNamespaceId(namespaceId);
        file.setRelativePath(relativePath);
        file.setBlockList(blockList);
        return file;
    }

    public List<File> download(List<String> blocks){
        return Collections.emptyList();
    }

    public List<String> upload(List<File> blocks){
        return Collections.emptyList();
    }
}
