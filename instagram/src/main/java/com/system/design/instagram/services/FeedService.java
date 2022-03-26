package com.system.design.instagram.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FeedService {
    //feed is changing by new photos
    public List<String> feedByUserId(Long userId, Integer imageCount, Date last_photo_timestamp){
        return Collections.emptyList();
    }
}
