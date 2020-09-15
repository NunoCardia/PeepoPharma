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
public class Sale extends dtoBaseModel implements Serializable {

  @JsonProperty("client")
  private String clientName;

  @JsonProperty("pharmaceutist")
  private String pharmaceutist;

  @JsonProperty("medications")
  private List<Medication> medications;

  @JsonProperty("saleTime")
  private LocalDateTime saleTime;

}
