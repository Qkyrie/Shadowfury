package com.deswaef.shadowfury.servermessage.domain;

import java.time.LocalDateTime;

public class ServerMessage {
    private Long id;
    private String message;
    private LocalDateTime timestamp;
    private boolean success;

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

    public boolean isSuccess() {
        return success;
    }

    public ServerMessage setSuccess(boolean success) {
        this.success = success;
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

        public Builder withId(long id) {
            message.setId(id);
            return this;
        }

        public Builder success() {
             message.setSuccess(true);
            return this;
        }

        public Builder failure() {
            message.setSuccess(false);
            return this;
        }

        public Builder withMessage(String messageString) {
            message.setMessage(messageString);
            return this;
        }

        public ServerMessage build() {
            return message;
        }
    }
}
