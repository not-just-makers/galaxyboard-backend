package com.justnotmakers.galaxyboard.api.exception;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ApiExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionMapper.class);

    private static final int DEFAULT_HTTP_ERROR_CODE = 404;

    @Override
    public Response toResponse(Exception e) {
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            return buildResponse(e, apiException.httpCode(), apiException.getPublicMessage());
        } else {
            return buildResponse(e, DEFAULT_HTTP_ERROR_CODE, e.getMessage());
        }
    }

    private Response buildResponse(Exception e, int httpCode, String message) {
        LOGGER.warn("{}: {}", e.getClass().getSimpleName(), message);
        return Response.status(httpCode)
            .entity(wrapExceptionMessage(message))
            .type(MediaType.APPLICATION_JSON_TYPE)
            .build();
    }

    private JsonObject wrapExceptionMessage(String message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("error", new JsonPrimitive(message));
        return jsonObject;
    }
}
