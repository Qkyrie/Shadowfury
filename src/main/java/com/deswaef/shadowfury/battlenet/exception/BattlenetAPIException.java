package com.deswaef.shadowfury.battlenet.exception;

public class BattlenetAPIException extends RuntimeException {
    public BattlenetAPIException() {
    }

    public BattlenetAPIException(String message) {
        super(message);
    }

    public BattlenetAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public BattlenetAPIException(Throwable cause) {
        super(cause);
    }

    public BattlenetAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
