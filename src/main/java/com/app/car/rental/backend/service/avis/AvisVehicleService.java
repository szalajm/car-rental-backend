package com.app.car.rental.backend.service.avis;

import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.web.controller.RestTemplateResponseErrorHandler;
import com.app.car.rental.backend.web.model.request.LocationSearchRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static com.app.car.rental.backend.web.controller.ControllerConstants.COUNTRY_CODE;
import static com.app.car.rental.backend.web.controller.ControllerConstants.DROPOFF_DATE;
import static com.app.car.rental.backend.web.controller.ControllerConstants.DROPOFF_LOCATION;
import static com.app.car.rental.backend.web.controller.ControllerConstants.PICKUP_DATE;
import static com.app.car.rental.backend.web.controller.ControllerConstants.PICKUP_LOCATION;

@Service
public class AvisVehicleService {
    public static final Logger LOGGER = Logger.getLogger(AvisLocationService.class.getName());

    @Autowired
    private AvisTokenService avisTokenService;

    public AvisApiVehicle vehicles(LocationSearchRequestDto locationSearchRequestDto) {
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
                //.queryParam("pickup_date", locationSearchRequestDto.getPickUpDate())
                .queryParam("pickup_date", URLEncoder.encode(PICKUP_DATE))
//                .queryParam("pickup_location", locationSearchRequestDto.getPickUpLocation())
                .queryParam("pickup_location", PICKUP_LOCATION)
                .queryParam("dropoff_date", URLEncoder.encode(DROPOFF_DATE))
                //.queryParam("dropoff_date", locationSearchRequestDto.getDropOffDate())
//                .queryParam("dropoff_location", locationSearchRequestDto.getDropOffLocation())
                .queryParam("dropoff_location", DROPOFF_LOCATION)
                .queryParam("country_code", COUNTRY_CODE)
                //.encode()
                .build(true);
        LOGGER.info("####: queryParams: " + builder.toUri());
        LOGGER.info("####: requestEntity: " + requestEntity);
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
            ObjectMapper objectMapper = new ObjectMapper();
            String bodyString = objectMapper.writeValueAsString(response.getBody());
            LOGGER.info("##### bodyString: " + bodyString);
            return response.getBody();
        } catch (RuntimeException e) {
            LOGGER.severe("####: restTemplate exchange exception");
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
