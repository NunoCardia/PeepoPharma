package com.peepopharma.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@JsonDeserialize(builder = Error.ErrorBuilder.class)
@Builder(builderClassName = "ErrorBuilder", toBuilder = true)
public class Error implements Serializable {

  private String reason;

  private String message;

  @JsonPOJOBuilder(withPrefix = "")
  public static class ErrorBuilder {

  }
}
