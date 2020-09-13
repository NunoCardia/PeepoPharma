package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale {

  @JsonProperty("id")
  private String id;

  @JsonProperty("client")
  private String clientName;

  @JsonProperty("pharmaceutist")
  private String pharmaceutist;

  @JsonProperty("medications")
  private List<Medication> medications;

  @JsonProperty("saleTime")
  private LocalDateTime saleTime;

}
