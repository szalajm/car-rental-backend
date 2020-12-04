package com.app.car.rental.backend.service.util;

import com.app.car.rental.backend.api.avis.model.common.AvisApiError;
import com.app.car.rental.backend.api.avis.model.common.AvisApiStatus;
import com.app.car.rental.backend.api.avis.model.common.AvisApiStatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvisApiExceptionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisApiExceptionUtil.class);

    public String extract(AvisApiStatusResponse response) {
        LOGGER.info("extract({})", response);

        StringBuilder sb = new StringBuilder();
        sb.append("Problem with Avis API call. ");

        if (response != null) {
            AvisApiStatus status = response.getStatus();
            if (status != null) {
                String requestTime = status.getRequestTime();
                Integer requestErrors = status.getRequestErrors();

                sb.append("Request time: ").append(requestTime).append("\n");
                sb.append("Request errors: ").append(requestErrors).append("\n");

                List<AvisApiError> errors = status.getErrors();
                if (errors != null) {
                    for (AvisApiError error : errors) {
                        sb.append("Error message: ").append(error.getMessage()).append("\n");
                        sb.append("Error code: ").append(error.getCode()).append("\n");
                        sb.append("Error reason: ").append(error.getReason()).append("\n");
                        sb.append("Error details: ").append(error.getDetails()).append("\n");
                    }
                }
            }
        }

        String extract = sb.toString();
        LOGGER.info("extract(...) = {}", extract);
        return extract;
    }
}
