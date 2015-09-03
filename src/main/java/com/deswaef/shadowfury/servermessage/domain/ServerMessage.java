package com.deswaef.shadowfury.servermessage.domain;

import java.time.LocalDateTime;

public class ServerMessage {
    private Long id;
    private String message;
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public ServerMessage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ServerMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ServerMessage setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static class Builder {
        private ServerMessage message;

        private Builder() {
            this.message = new ServerMessage().setId(System.currentTimeMillis()).setTimestamp(LocalDateTime.now());
        }

        public static Builder create() {
            return new Builder();
        }

        public ServerMessage withId(long id) {
            return message.setId(id);
        }

        public ServerMessage withMessage(String messageString) {
            return message.setMessage(messageString);
        }
    }
}
