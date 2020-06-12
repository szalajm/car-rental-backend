
package com.app.car.rental.backend.api.avis.model.vehicle;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request_time",
    "success"
})
public class Status {

    @JsonProperty("request_time")
    private String requestTime;
    @JsonProperty("success")
    private List<Success> success = null;
    @JsonProperty("request_errors")
    private Integer requestErrors;
    @JsonProperty("errors")
    private List<Error> errors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("request_time")
    public String getRequestTime() {
        return requestTime;
    }

    @JsonProperty("request_time")
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    @JsonProperty("request_errors")
    public Integer getRequestErrors() {
        return requestErrors;
    }

    @JsonProperty("request_errors")
    public void setRequestErrors(Integer requestErrors) {
        this.requestErrors = requestErrors;
    }

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @JsonProperty("success")
    public List<Success> getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(List<Success> success) {
        this.success = success;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
