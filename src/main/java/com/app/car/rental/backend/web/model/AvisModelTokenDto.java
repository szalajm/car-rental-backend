package com.app.car.rental.backend.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvisModelTokenDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    //@JsonProperty("access_token")
    private String accessToken;
    //@JsonProperty("token_type")
    private String tokenType;
    //@JsonProperty("expires_in")
    private Integer expiresIn;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
