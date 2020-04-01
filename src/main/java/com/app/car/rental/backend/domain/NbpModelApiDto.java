package com.app.car.rental.backend.domain;

import com.app.car.rental.backend.api.nbp.model.Rate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class NbpModelApiDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JsonProperty("table")
    private String table;
    //@JsonProperty("no")
    private String no;
    //@JsonProperty("effectiveDate")
    private String effectiveDate;
    //@JsonProperty("rates")
    private List<Rate> rates = null;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
