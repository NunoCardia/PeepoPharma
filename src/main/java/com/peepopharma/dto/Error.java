package com.peepopharma.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

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
