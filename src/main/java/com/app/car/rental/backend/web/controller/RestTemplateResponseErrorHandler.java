package com.app.car.rental.backend.web.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger LOGGER = Logger.getLogger(RestTemplateResponseErrorHandler.class.getName());


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        LOGGER.info("wyloguj response" + response.getBody());
        LOGGER.info("wyloguj response" + response.getClass());
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        LOGGER.info("wyloguj response" + response.getBody());
        LOGGER.info("wyloguj response" + response.getClass());
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        LOGGER.info("wyloguj response" + response.getBody());
        LOGGER.info("wyloguj response" + response.getClass());
    }
}