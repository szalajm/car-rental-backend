package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class AvisReservationService {
    public static final Logger LOGGER = Logger.getLogger(AvisReservationService.class.getName());
    private AvisTokenService avisTokenService;

    public AvisReservationService(AvisTokenService avisTokenService) {
        this.avisTokenService = avisTokenService;
    }

    public AvisApiReservationPostResponse reservations(AvisApiReservationPostRequest avisApiReservation) throws Exception { //TODO : poprawna obsluga wlasnych wyjatkow
        AvisApiToken avisApiToken = avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyString = objectMapper.writeValueAsString(avisApiReservation);

        LOGGER.info("AvisApiReservationRequest: " + bodyString);

        HttpHeaders headers = new HttpHeaders();
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("Authorization", authorizationToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(bodyString, headers);

        String serverUrl = "https://stage.abgapiservices.com/cars/reservation/v1";

        //ResponseEntity<AvisApiReservationPostRequest> response = restTemplate.exchange(serverUrl, HttpMethod.POST, requestEntity, AvisApiReservationPostRequest.class);
        ResponseEntity<AvisApiReservationPostResponse> response = restTemplate.postForEntity(serverUrl, requestEntity, AvisApiReservationPostResponse.class);
        LOGGER.info("" + response.getBody());

        return response.getBody();
    }
}

