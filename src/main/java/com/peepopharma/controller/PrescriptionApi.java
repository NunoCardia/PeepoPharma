package com.peepopharma.controller;

import com.peepopharma.dto.Prescription;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Api(value = "Prescription", tags = "the Prescription API")
public interface PrescriptionApi {

  @ApiOperation(value = "Creates a Prescription", nickname = "createPrescription",
      notes = "This operation creates a Prescription entity", response = Prescription.class)
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created", response = Prescription.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PostMapping(value = "/prescription", produces = {"application/json"}, consumes = {
      "application/json"})
  ResponseEntity<Prescription> createPrescription(
      @ApiParam(value = "The Prescription to be created", required = true) @Valid @RequestBody
          Prescription PrescriptionDto);

  @ApiOperation(value = "Deletes a Prescription", nickname = "deletePrescription",
      notes = "This operation deletes a Prescription entity")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Deleted"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @DeleteMapping(value = "/prescription/{id}", produces = {"application/json"})
  ResponseEntity<Void> deletePrescription(
      @ApiParam(value = "The identifier of the Prescription", required = true) @PathVariable("id") String id);

  @ApiOperation(value = "List or find Prescription objects", nickname = "listPrescription",
      notes = "This operation lists or finds Prescription entities", response = Prescription.class,
      responseContainer = "List")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = Prescription.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/prescription", produces = {"application/json"})
  ResponseEntity<List<Prescription>> listPrescription(
      @ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
      @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);

  @ApiOperation(value = "Retrieves a Prescription by ID", nickname = "retrievePrescription",
      notes = "This operation retrieves a Prescription entity. Attribute selection is enabled for all first level attributes", response = Prescription.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = Prescription.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/prescription/{id}", produces = {"application/json"})
  ResponseEntity<Prescription> listPrescription(
      @ApiParam(value = "Identifier of the Prescription", required = true) @PathVariable("id") String id,
      @ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);
}