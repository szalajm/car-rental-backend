package com.app.car.rental.backend.service.avis;

import com.app.car.rental.backend.api.avis.model.common.AvisApiStatusResponse;
import com.app.car.rental.backend.api.exception.AvisApiException;
import com.app.car.rental.backend.api.exception.reservation.ReservationAvisApiException;
import com.app.car.rental.backend.service.util.AvisApiExceptionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AvisServiceUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisServiceUtils.class);
    private static final String AVIS_CLIENT_ID_KEY = "client_id";
    private static final String AVIS_CLIENT_ID_VALUE = "2d8fd8f532234bd484e512d83aec3b4e";

    private final AvisTokenService avisTokenService;
    private AvisApiExceptionUtil avisApiExceptionUtil;

    public AvisServiceUtils(AvisTokenService avisTokenService, AvisApiExceptionUtil avisApiExceptionUtil) {
        this.avisTokenService = avisTokenService;
        this.avisApiExceptionUtil = avisApiExceptionUtil;
    }

    public Headers createHeaders() {
        LOGGER.info("createHeaders()");
        String authorizationToken = avisTokenService.authorizationToken();

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put(AVIS_CLIENT_ID_KEY, AVIS_CLIENT_ID_VALUE);
        headersMap.put("Authorization", authorizationToken);
        headersMap.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        Headers headers = Headers.of(headersMap);
        LOGGER.info("createHeaders() = {}", headers);
        return headers;
    }

    public void avisApiStatusResponseHandler(ObjectMapper objectMapper, String responseBodyString) throws AvisApiException {
        AvisApiStatusResponse avisApiStatusResponse;
        try {
            avisApiStatusResponse = objectMapper.readValue(responseBodyString, AvisApiStatusResponse.class);
            LOGGER.info("avisApiStatusResponse: {}", avisApiStatusResponse);
        } catch (JsonProcessingException e) {
            LOGGER.error("Parsing response JSON problem: " + e.getMessage(), e);
            throw new ReservationAvisApiException("Parsing response JSON problem: " + e.getMessage(), e);
        }
        throw new ReservationAvisApiException("Avis Api response error. " + avisApiExceptionUtil.extract(avisApiStatusResponse));
    }
}
