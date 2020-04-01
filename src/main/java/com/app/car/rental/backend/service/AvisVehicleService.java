package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
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

public class AvisVehicleService {
    public static final Logger LOGGER = Logger.getLogger(AvisLocationService.class.getName());

    @Autowired
    private AvisTokenService avisTokenService;

    public void vehicles() {
        AvisApiToken avisApiToken = avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("Authorization", authorizationToken);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        //body.add("file", getTestFile());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://stage.abgapiservices.com/cars/catalog/v1/vehicles";

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("brand", "Avis");
//        parameters.put("pickup_date", "2020-03-08T04%3A00%3A00");
//        parameters.put("pickup_location", "EWR");
//        parameters.put("dropoff_date", "2020-03-10T04%3A00%3A00");
//        parameters.put("dropoff_location", "EWR");
//        parameters.put("country_code", "US");


        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(serverUrl)
                // Add query parameter
                .queryParam("lat", "42.3736861242963")
                .queryParam("long", "-71.029931402219")
                .queryParam("brand", "Avis")
                .queryParam("pickup_date", "2020-03-08T04%3A00%3A00")
                .queryParam("pickup_location", "EWR")
                .queryParam("dropoff_date", "2020-03-10T04%3A00%3A00")
                .queryParam("dropoff_location", "EWR")
                .queryParam("country_code", "US");


        ResponseEntity<AvisApiVehicle> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AvisApiVehicle.class);

        LOGGER.info("#### responseBody: " + response.getBody());
    }

}
