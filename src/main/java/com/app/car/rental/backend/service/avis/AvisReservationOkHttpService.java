package com.app.car.rental.backend.service.avis;

import com.app.car.rental.backend.api.avis.model.common.AvisApiStatusResponse;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.exception.reservation.ReservationAvisApiException;
import com.app.car.rental.backend.service.util.AvisApiExceptionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AvisReservationOkHttpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisReservationOkHttpService.class);

    private static final String SERVER_URL = "https://stage.abgapiservices.com/cars/reservation/v1";

    private final AvisServiceUtils avisServiceUtils;
    private final AvisApiExceptionUtil avisApiExceptionUtil;

    public AvisReservationOkHttpService(AvisServiceUtils avisServiceUtils, AvisApiExceptionUtil avisApiExceptionUtil) {
        this.avisServiceUtils = avisServiceUtils;
        this.avisApiExceptionUtil = avisApiExceptionUtil;
    }

    public AvisApiReservationPostResponse reservations(AvisApiReservationPostRequest avisApiReservation)
            throws ReservationAvisApiException, IOException {
        LOGGER.info("reservations({})", avisApiReservation);

        OkHttpClient client = new OkHttpClient();
        Headers headers = avisServiceUtils.createHeaders();

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
            LOGGER.info("avisApiReservationPostResponse: {}", avisApiReservationPostResponse);
        } else {
            // FIXME: parse JSON with errors...
            AvisApiStatusResponse avisApiStatusResponse = null;
            try {
                avisApiStatusResponse = objectMapper.readValue(responseBodyString, AvisApiStatusResponse.class);
            } catch (JsonProcessingException e) {
                LOGGER.error("Parsing response JSON problem: " + e.getMessage(), e);
                throw new ReservationAvisApiException("Parsing response JSON problem: " + e.getMessage(), e);
            }
            LOGGER.info("avisApiStatusResponse: {}", avisApiStatusResponse);
            throw new ReservationAvisApiException("Avis Api response error. " + avisApiExceptionUtil.extract(avisApiStatusResponse));
        }

        LOGGER.info("#### response body: {}", responseBodyString);

        return null;
    }
}
