package com.deswaef.shadowfury.wowhead.exception;

public class WowHeadApiException extends RuntimeException {
    public WowHeadApiException() {
    }

    public WowHeadApiException(String message) {
        super(message);
    }

    public WowHeadApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public WowHeadApiException(Throwable cause) {
        super(cause);
    }

    public WowHeadApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
