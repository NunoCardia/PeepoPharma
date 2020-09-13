package com.peepopharma.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("address")
  private String address;

  @JsonProperty("citizenCard")
  private String citizenCard;

  @JsonProperty("VAT")
  private String vat;

  @JsonProperty("phoneNumber")
  private String phoneNumber;

  @JsonProperty("role")
  private String role;

}
