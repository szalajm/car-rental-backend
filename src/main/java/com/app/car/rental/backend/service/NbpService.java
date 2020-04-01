package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.nbp.model.NbpApi;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.logging.Logger;

public class NbpService {
    public static final Logger LOGGER = Logger.getLogger(NbpService.class.getName());

    public void rates() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.add("Accept", "application/json");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "http://api.nbp.pl/api/exchangerates/tables/A/";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serverUrl);

        ResponseEntity<NbpApi[]> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, NbpApi[].class);

        LOGGER.info("responseLength: " + response.getBody().length);

        LOGGER.info("responseElement: " + response.getBody()[0].getNo());

        LOGGER.info("#### responseBody: " + Arrays.toString(response.getBody()));

    }
}
