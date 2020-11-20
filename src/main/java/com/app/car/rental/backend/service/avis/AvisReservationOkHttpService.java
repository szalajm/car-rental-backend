package com.app.car.rental.backend.service.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class AvisReservationOkHttpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisReservationOkHttpService.class);

    private static final String SERVER_URL = "https://stage.abgapiservices.com/cars/reservation/v1";

    private final AvisTokenService avisTokenService;

    public AvisReservationOkHttpService(AvisTokenService avisTokenService) {
        this.avisTokenService = avisTokenService;
    }

    public AvisApiReservationPostResponse reservations(AvisApiReservationPostRequest avisApiReservation) throws IOException {
        LOGGER.info("reservations({})", avisApiReservation);

        String authorizationToken = avisTokenService.authorizationToken();

        OkHttpClient client = new OkHttpClient();

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("client_id", "2d8fd8f532234bd484e512d83aec3b4e");
        headersMap.put("Authorization", authorizationToken);
        headersMap.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        Headers headers = Headers.of(headersMap);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyString = objectMapper.writeValueAsString(avisApiReservation);
        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), requestBodyString);

        Request request = new Request.Builder()
                .url(SERVER_URL)
                .headers(headers)
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        int responseStatus = response.code();
        ResponseBody responseBody = response.body();

        String responseBodyString = responseBody.string();
        if (HttpStatus.OK.value() == responseStatus
                || HttpStatus.CREATED.value() == responseStatus) {
            AvisApiReservationPostResponse avisApiReservationPostResponse =
                    objectMapper.readValue(responseBodyString, AvisApiReservationPostResponse.class);
            LOGGER.info("avisApiReservationPostResponse: " + avisApiReservationPostResponse);
        } else {
            // FIXME: parse JSON with errors...
        }

        LOGGER.info("#### response body: {}", responseBodyString);

        return null;
    }
}