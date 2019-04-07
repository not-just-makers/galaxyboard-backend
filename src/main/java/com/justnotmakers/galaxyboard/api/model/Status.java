package com.justnotmakers.galaxyboard.api.model;

/**
 * API status.
 *
 * @author asanchez
 */
public class Status {

    public static final Status OK = new Status("OK", false);

    private String message;
    private boolean isError;

    public Status(String message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }

    /**
     * Gets message.
     *
     * @return Message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets a message.
     *
     * @param message Message to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public static Status error(String error) {
        return new Status(error, true);
    }

    public static Status ok(String message) {
        return new Status(message, false);
    }
}
