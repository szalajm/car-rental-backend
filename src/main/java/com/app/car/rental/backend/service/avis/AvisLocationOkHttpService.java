package com.app.car.rental.backend.service.avis;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.exception.AvisApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AvisLocationOkHttpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisLocationOkHttpService.class);

    private static final String SERVER_URL = "https://stage.abgapiservices.com/cars/locations/v1";
    private static final String QUERY_PARAMETER_KEYWORD = "keyword";

    @Autowired
    private AvisTokenService avisTokenService;
    @Autowired
    private AvisServiceUtils avisServiceUtils;

    public AvisApiLocation locations(String location) throws AvisApiException, IOException {
        LOGGER.info("locations({})", location);

        OkHttpClient client = new OkHttpClient();
        Headers headers = avisServiceUtils.createHeaders();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(SERVER_URL).newBuilder();
        urlBuilder.addQueryParameter(QUERY_PARAMETER_KEYWORD, location);

        String url = urlBuilder.build().toString();
        LOGGER.info("request URL: {}", url);

        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        int responseStatus = response.code();
        ResponseBody responseBody = response.body();
        String responseBodyString = responseBody.string();

        ObjectMapper objectMapper = new ObjectMapper();
        if (HttpStatus.OK.value() == responseStatus || HttpStatus.CREATED.value() == responseStatus) {
            AvisApiLocation avisApiLocation = objectMapper.readValue(responseBodyString, AvisApiLocation.class);
            LOGGER.info("avisApiLocation: {}", avisApiLocation);
        } else {
            avisServiceUtils.avisApiStatusResponseHandler(objectMapper, responseBodyString);
        }

        LOGGER.info("#### response body: {}", responseBodyString);

        return null;

//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

//        UriComponents builder = UriComponentsBuilder
//                .fromUriString(SERVER_URL)
////                .queryParam("keyword", location)
//                .queryParam(QUERY_PARAMETER_KEYWORD, "warsaw")
//                .build(true);

//        ResponseEntity<AvisApiLocation> response = ResponseEntity.noContent().build();
//
//        try {
//            response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, requestEntity, AvisApiLocation.class);
//            URI uri = builder.toUri();
//            LOGGER.info("#### url: " + uri);
////            AvisApiLocation avisApiLocation = restTemplate.postForObject(uri, requestEntity, AvisApiLocation.class);
//            LOGGER.info("#### responseBody: " + response.getBody());
////            LOGGER.info("#### avisApiLocation: " + avisApiLocation);
//        } catch (RestClientException e) {
//            LOGGER.info("#### exception message: " + e.getMessage());
//            LOGGER.info("#### response body: " + response);
//            e.printStackTrace();
//        }

//        return response.getBody();
    }
}
