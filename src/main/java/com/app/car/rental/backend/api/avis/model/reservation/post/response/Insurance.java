
package com.app.car.rental.backend.api.avis.model.reservation.post.response;

import java.util.HashMap;
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
    "code",
    "name",
    "amount",
    "total_owed",
    "tax_included",
    "selected",
    "selection_note"
})
public class Insurance {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("total_owed")
    private Double totalOwed;
    @JsonProperty("tax_included")
    private Boolean taxIncluded;
    @JsonProperty("selected")
    private Boolean selected;
    @JsonProperty("selection_note")
    private String selectionNote;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("total_owed")
    public Double getTotalOwed() {
        return totalOwed;
    }

    @JsonProperty("total_owed")
    public void setTotalOwed(Double totalOwed) {
        this.totalOwed = totalOwed;
    }

    @JsonProperty("tax_included")
    public Boolean getTaxIncluded() {
        return taxIncluded;
    }

    @JsonProperty("tax_included")
    public void setTaxIncluded(Boolean taxIncluded) {
        this.taxIncluded = taxIncluded;
    }

    @JsonProperty("selected")
    public Boolean getSelected() {
        return selected;
    }

    @JsonProperty("selected")
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @JsonProperty("selection_note")
    public String getSelectionNote() {
        return selectionNote;
    }

    @JsonProperty("selection_note")
    public void setSelectionNote(String selectionNote) {
        this.selectionNote = selectionNote;
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
        return new ToStringBuilder(this).append("code", code).append("name", name).append("amount", amount).append("totalOwed", totalOwed).append("taxIncluded", taxIncluded).append("selected", selected).append("selectionNote", selectionNote).append("additionalProperties", additionalProperties).toString();
    }

}
