package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Medication extends dtoBaseModel implements Serializable {


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
