package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
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
public class AvisLocationService {
    public static final Logger LOGGER = Logger.getLogger(AvisLocationService.class.getName());

    @Autowired
    private AvisTokenService avisTokenService;

    public void locations(){
        AvisApiToken avisApiToken= avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        //headers.add("Authorization", "Bearer 00013Q4W10DuJxMARsRt9DlG5i2U");
        headers.add("Authorization", authorizationToken);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        //body.add("file", getTestFile());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://stage.abgapiservices.com/cars/locations/v1";

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("lat", "42.3736861242963");
//        parameters.put("long", "-71.029931402219");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(serverUrl)
                // Add query parameter
                .queryParam("lat", "42.3736861242963")
                .queryParam("long", "-71.029931402219");

        //String response = restTemplate.getForObject(builder.toUriString(), String.class);
        //ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, String.class);
        ResponseEntity<AvisApiLocation> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AvisApiLocation.class);
        //ResponseEntity<String> response = restTemplate.getForEntity(serverUrl, String.class, parameters);
        //String responseBody = response.getBody();
        LOGGER.info("#### responseBody: " + response.getBody());

    }
}
