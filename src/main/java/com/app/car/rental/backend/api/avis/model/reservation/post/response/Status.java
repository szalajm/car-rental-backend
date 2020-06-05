
package com.app.car.rental.backend.api.avis.model.reservation.post.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("requestTime", requestTime).append("success", success).append("additionalProperties", additionalProperties).toString();
    }

}
