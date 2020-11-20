package com.app.car.rental.backend.service.avis;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import com.app.car.rental.backend.web.controller.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.logging.Logger;

@Service
public class AvisLocationService {
    public static final Logger LOGGER = Logger.getLogger(AvisLocationService.class.getName());

    private static final String SERVER_URL = "https://stage.abgapiservices.com/cars/locations/v1";

    @Autowired
    private AvisTokenService avisTokenService;

    public AvisApiLocation locations(String location){
        AvisApiToken avisApiToken= avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("Authorization", authorizationToken);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        UriComponents builder = UriComponentsBuilder
                .fromUriString(SERVER_URL)
//                .queryParam("keyword", location)
                .queryParam("keyword", "warsaw")
                .build(true);

        ResponseEntity<AvisApiLocation> response = ResponseEntity.noContent().build();

        try {
            response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, requestEntity, AvisApiLocation.class);
            URI uri = builder.toUri();
            LOGGER.info("#### url: " + uri);
//            AvisApiLocation avisApiLocation = restTemplate.postForObject(uri, requestEntity, AvisApiLocation.class);
            LOGGER.info("#### responseBody: " + response.getBody());
//            LOGGER.info("#### avisApiLocation: " + avisApiLocation);
        } catch (RestClientException e) {
            LOGGER.info("#### exception message: " + e.getMessage());
            LOGGER.info("#### response body: " + response);
            e.printStackTrace();
        }

        return response.getBody();
    }
}
