package com.justnotmakers.galaxyboard.api.exception;

/**
 * Exception thrown by the API.
 *
 * @author asanchez
 */
public abstract class ApiException extends RuntimeException {

    /**
     * Gets message.
     *
     * @return Message.
     */
    public abstract String getPublicMessage();

    /**
     * Gets HTTP code.
     *
     * @return HTTP code.
     */
    public abstract int httpCode();
}
