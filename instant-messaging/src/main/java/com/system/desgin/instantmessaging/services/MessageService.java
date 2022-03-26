package com.system.desgin.instantmessaging.services;

import com.system.desgin.instantmessaging.model.Message;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    /*** WebSocket Stomp format
     *  SEND:
     *  destination: /messages
     *  [{
     *      "to_user_id": 21312312
     *      "text": "Hello world"
     *      "ts": 1910432919
     *  }]
     *  Multi-Message format
     */
    public boolean sendMessage(Message message) {
        return false;
    }
}
