package org.itstep.websocket;

import java.time.LocalDateTime;

public class Message {
    int id;
    String message;
    LocalDateTime localDateTime;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
