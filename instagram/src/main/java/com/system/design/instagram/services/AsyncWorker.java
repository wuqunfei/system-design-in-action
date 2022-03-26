package com.system.design.instagram.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service //moving post into feed table async

public class AsyncWorker {

    @Async
    public void movingPostIntoFeed(){

    }
}
