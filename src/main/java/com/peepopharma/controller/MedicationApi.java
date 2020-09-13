package com.peepopharma.controller;

import com.peepopharma.dto.Medication;
import com.peepopharma.dto.MedicationUpdate;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Api(value = "Medication", tags = "the Medication API")
public interface MedicationApi {

  @ApiOperation(value = "Creates a Medication", nickname = "createMedication",
      notes = "This operation creates a Medication entity", response = Medication.class)
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created", response = Medication.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PostMapping(value = "/medication", produces = {"application/json"}, consumes = {
      "application/json"})
  ResponseEntity<Medication> createMedication(
      @ApiParam(value = "The Medication to be created", required = true) @Valid @RequestBody
          Medication medicationDto);

  @ApiOperation(value = "Deletes a Medication", nickname = "deleteMedication",
      notes = "This operation deletes a Medication entity")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Deleted"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @DeleteMapping(value = "/medication/{id}", produces = {"application/json"})
  ResponseEntity<Void> deleteMedication(
      @ApiParam(value = "The identifier of the Medication", required = true) @PathVariable("id") String id);

  @ApiOperation(value = "List or find Medication objects", nickname = "listMedication",
      notes = "This operation lists or finds Medication entities", response = Medication.class,
      responseContainer = "List")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = Medication.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/medication", produces = {"application/json"})
  ResponseEntity<List<Medication>> listMedication(
      @ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
      @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);

  @ApiOperation(value = "Updates partially a Medication", nickname = "patchMedication",
      notes = "This operation updates partially a Medication entity", response = Medication.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Updated", response = Medication.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PatchMapping(value = "/medication/{id}", consumes = {"application/json"}, produces = {
      "application/json"})
  ResponseEntity<Medication> patchMedication(
      @ApiParam(value = "Identifier of the Medication", required = true) @PathVariable("id") String id,
      @ApiParam(value = "The Medication to be updated", required = true) @Valid @RequestBody MedicationUpdate Medication);


  @ApiOperation(value = "Retrieves a Medication by ID", nickname = "retrieveMedication",
      notes = "This operation retrieves a Medication entity. Attribute selection is enabled for all first level attributes", response = Medication.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = Medication.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/medication/{id}", produces = {"application/json"})
  ResponseEntity<Medication> listMedication(
      @ApiParam(value = "Identifier of the Medication", required = true) @PathVariable("id") String id,
      @ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);

}
