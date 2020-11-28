package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrescriptionDto extends BaseModel implements Serializable {

    @JsonProperty("prescriptionNumber")
    private String prescriptionNumber;

    @JsonProperty("medications")
    private List<MedicationDto> medicationDtos;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("client")
    private String clientName;

    @JsonProperty("doctor")
    private String doctorName;

}
