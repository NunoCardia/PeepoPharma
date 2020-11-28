package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleDto extends BaseModel implements Serializable {

    @JsonProperty("client")
    private String clientName;

    @JsonProperty("pharmaceutist")
    private String pharmaceutist;

    @JsonProperty("medications")
    private List<MedicationDto> medicationDtos;

    @JsonProperty("saleTime")
    private LocalDateTime saleTime;

}
