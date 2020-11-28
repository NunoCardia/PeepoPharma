package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicationDto extends BaseModel implements Serializable {

    @JsonProperty("medicationNumber")
    private String medicationNumber;

    @JsonProperty("medicationStatus")
    private String medicationStatus;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("dosage")
    private String dosage;

}
