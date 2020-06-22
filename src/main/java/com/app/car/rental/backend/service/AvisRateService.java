package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.logging.Logger;
@Service
public class AvisRateService {
    public static final Logger LOGGER = Logger.getLogger(AvisRateService.class.getName());

    @Autowired
    public AvisTokenService avisTokenService;

    public AvisApiRate rates(){

        AvisApiToken avisApiToken = avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("Authorization", authorizationToken);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://stage.abgapiservices.com/cars/catalog/v1/vehicles/rates";

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(serverUrl)
                .queryParam("brand", "Avis")
                .queryParam("pickup_date", "2020-03-10T18:26:00")
                .queryParam("pickup_location", "EWR")
                .queryParam("dropoff_date", "2020-03-15T18:26:00")
                .queryParam("dropoff_location", "EWR")
                .queryParam("country_code", "US")
                .queryParam("vehicle_class_code", "A")
                .queryParam("rate_code", "DH");

        ResponseEntity<AvisApiRate> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AvisApiRate.class);

        LOGGER.info("#### responseBody: " + response.getBody());
        return response.getBody();

    }
}
