package com.app.car.rental.backend.service.avis;

import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AvisServiceUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisServiceUtils.class);
    private static final String AVIS_CLIENT_ID = "2d8fd8f532234bd484e512d83aec3b4e";

    private AvisTokenService avisTokenService;

    public Headers createHeaders() {
        LOGGER.info("createHeaders()");
        String authorizationToken = avisTokenService.authorizationToken();

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("client_id", AVIS_CLIENT_ID);
        headersMap.put("Authorization", authorizationToken);
        headersMap.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        Headers headers = Headers.of(headersMap);
        LOGGER.info("createHeaders() = {}", headers);
        return headers;
    }
}
