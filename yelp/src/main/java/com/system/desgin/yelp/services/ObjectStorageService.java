package com.system.desgin.yelp.services;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ObjectStorageService {

    private AmazonS3Client s3;

    @Autowired
    public ObjectStorageService(AmazonS3Client s3) {
        this.s3 = s3;
    }

    public Bucket createBucket(String bucketName) {
        return s3.createBucket(bucketName);
    }

    public void uploadPhoto(Long userId, String bucketName, File photo) {
        s3.putObject(bucketName, Long.toString(userId), photo);
    }
}
