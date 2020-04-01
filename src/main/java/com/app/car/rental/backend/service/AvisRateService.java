package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.logging.Logger;

public class AvisRateService {

    public static final Logger LOGGER = Logger.getLogger(AvisRateService.class.getName());

    @Autowired
    private AvisTokenService avisTokenService;

    public void rates(){

        AvisApiToken avisApiToken = avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("Authorization", authorizationToken);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        //body.add("file", getTestFile());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://stage.abgapiservices.com/cars/catalog/v1/vehicles/rates";

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("brand", "Avis");
//        parameters.put("pickup_date", "2020-03-10T18:26:17+0100");
//        parameters.put("pickup_location", "EWR");
//        parameters.put("dropoff_date", "2020-03-15T18:26:17+0100");
//        parameters.put("country_code", "US");
//        parameters.put("vehicle_class_code","A");
//        parameters.put("rate_code", "DH");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(serverUrl)
                // Add query parameter
                .queryParam("brand", "Avis")
                .queryParam("pickup_date", "2020-03-10T18:26:17+0100")
                .queryParam("pickup_location", "EWR")
                .queryParam("dropoff_date", "2020-03-15T18:26:17+0100")
                .queryParam("dropoff_location", "EWR")
                .queryParam("country_code", "US")
                .queryParam("vehicle_class_code","A")
                .queryParam("rate_code", "DH");

        //String response = restTemplate.getForObject(builder.toUriString(), String.class);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, String.class);
        //ResponseEntity<AvisApiRate> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AvisApiRate.class);
        //ResponseEntity<String> response = restTemplate.getForEntity(serverUrl, String.class, parameters);
        //String responseBody = response.getBody();
        LOGGER.info("#### responseBody: " + response.getBody());
    }
}