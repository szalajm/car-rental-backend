package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.controller.RestTemplateResponseErrorHandler;
import com.app.car.rental.backend.domain.CarSearchRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.util.logging.Logger;

@Service
public class AvisVehicleService {
    public static final Logger LOGGER = Logger.getLogger(AvisLocationService.class.getName());

    @Autowired
    private AvisTokenService avisTokenService;

    public AvisApiVehicle vehicles(CarSearchRequestDto carSearchRequestDto) {
        AvisApiToken avisApiToken = avisTokenService.token();
        String authorizationToken = avisApiToken.getTokenType() + " " + avisApiToken.getAccessToken();

        RestTemplate restTemplate = new RestTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();

        //restTemplate.errorHandler(new RestTemplateResponseErrorHandler());

        HttpHeaders headers = new HttpHeaders();
        headers.add("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headers.add("Authorization", authorizationToken);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://stage.abgapiservices.com/cars/catalog/v1/vehicles";

        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(serverUrl)
                // Add query parameter
                .queryParam("brand", "Avis")
                //.queryParam("pickup_date", carSearchRequestDto.getPickUpDate())
                .queryParam("pickup_date", URLEncoder.encode("2020-08-05T12:00:00"))
                .queryParam("pickup_location", carSearchRequestDto.getPickUpLocation())
                .queryParam("dropoff_date", URLEncoder.encode("2020-08-07T12:00:00"))
                //.queryParam("dropoff_date", carSearchRequestDto.getDropOffDate())
                .queryParam("dropoff_location", carSearchRequestDto.getDropOffLocation())
                .queryParam("country_code", "PL")
                //.encode()
                .build(true);
        LOGGER.info("####: queryParams: " + builder.toUri());
        try {
//            String instanceUrl = "https://abc.my.salesforce.com"
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            UriComponents uriComponents =
//                    UriComponentsBuilder.fromHttpUrl(instanceUrl)
//                            .path("/services/data/v45.0/query/")
//                            .queryParam("q", String.format(sqlSelect, id))
//                            .build();
//
//            ResponseEntity<OpportunityLineItem> responseEntity =
//                    restTemplate.exchange(
//                            uriComponents.toUri(), HttpMethod.GET,
//                            entity, OpportunityLineItem.class);
            ResponseEntity<AvisApiVehicle> response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, requestEntity, AvisApiVehicle.class);

            LOGGER.info("#### responseBody: " + response.getBody());
            return response.getBody();
        } catch (RuntimeException e) {
            LOGGER.severe("####: restTemplate exchange exception");
            e.printStackTrace();
        }
        return null;
    }

}
