package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.api.avis.model.token.AvisApiToken;
import com.app.car.rental.backend.web.model.AvisModelTokenDto;
import org.springframework.stereotype.Service;

@Service
public class AvisModelTokenMapper {

    public AvisModelTokenDto mapToAvisModelTokenDto(AvisApiToken avisApiToken){
        return new AvisModelTokenDto(avisApiToken.getAccessToken(), avisApiToken.getTokenType(), avisApiToken.getExpiresIn(),
                avisApiToken.getAdditionalProperties());
    }
}
