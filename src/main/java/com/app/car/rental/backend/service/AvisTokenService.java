package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
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
public class AvisTokenService {
    public static final Logger LOGGER = Logger.getLogger(AvisTokenService.class.getName());

    public AvisApiToken token(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("client_secret", "e1fE6431573b492581a41D4D7C63850C");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://stage.abgapiservices.com/oauth/token/v1";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serverUrl);

        //ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, String.class);
        ResponseEntity<AvisApiToken> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AvisApiToken.class);

        LOGGER.info("#### responseBody:" + response.getBody());

        return response.getBody();

    }
}
