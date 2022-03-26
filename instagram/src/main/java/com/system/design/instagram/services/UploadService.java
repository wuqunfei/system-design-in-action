package com.system.design.instagram.services;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class UploadService {

    public boolean uploadPhoto(InputStream stream, Long userId){
        // upload to object storage
        // update post table
        return false;
    }
}
