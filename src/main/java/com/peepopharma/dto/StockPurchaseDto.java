package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockPurchaseDto extends BaseModel implements Serializable {

  @JsonProperty("companyName")
  private String companyName;

  @JsonProperty("medications")
  private List<MedicationDto> medicationDtos;

  @JsonProperty("adminName")
  private String adminName;

  @JsonProperty("purchaseTime")
  private LocalDateTime purchaseTime;


}
