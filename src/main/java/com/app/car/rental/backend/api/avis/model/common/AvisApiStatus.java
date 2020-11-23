
package com.app.car.rental.backend.api.avis.model.common;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "request_time",
        "success",
        "request_errors",
        "errors"
})
public class AvisApiStatus {

    @JsonProperty("request_time")
    private String requestTime;
    @JsonProperty("success")
    private List<AvisApiSuccess> success = null;
    @JsonProperty("request_errors")
    private Integer requestErrors;
    @JsonProperty("errors")
    private List<AvisApiError> errors = null;
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
    public List<AvisApiError> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<AvisApiError> errors) {
        this.errors = errors;
    }

    @JsonProperty("success")
    public List<AvisApiSuccess> getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(List<AvisApiSuccess> success) {
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

    @Override
    public String toString() {
        return "AvisApiStatusResponse{" +
                "requestTime='" + requestTime + '\'' +
                ", success=" + success +
                ", requestErrors=" + requestErrors +
                ", errors=" + errors +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
