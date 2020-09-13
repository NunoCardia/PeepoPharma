package com.peepopharma.controller;

import com.peepopharma.dto.StockPurchase;
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
@Api(value = "StockPurchase", tags = "the StockPurchase API")
public interface StockPurchaseApi {

  @ApiOperation(value = "Creates a StockPurchase", nickname = "createStockPurchase",
      notes = "This operation creates a StockPurchase entity", response = StockPurchase.class)
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created", response = StockPurchase.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PostMapping(value = "/stockPurchase", produces = {"application/json"}, consumes = {
      "application/json"})
  ResponseEntity<StockPurchase> createStockPurchase(
      @ApiParam(value = "The StockPurchase to be created", required = true) @Valid @RequestBody
          StockPurchase StockPurchaseDto);

  @ApiOperation(value = "Deletes a StockPurchase", nickname = "deleteStockPurchase",
      notes = "This operation deletes a StockPurchase entity")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Deleted"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @DeleteMapping(value = "/stockPurchase/{id}", produces = {"application/json"})
  ResponseEntity<Void> deleteStockPurchase(
      @ApiParam(value = "The identifier of the StockPurchase", required = true) @PathVariable("id") String id);

  @ApiOperation(value = "List or find StockPurchase objects", nickname = "listStockPurchase",
      notes = "This operation lists or finds StockPurchase entities", response = StockPurchase.class,
      responseContainer = "List")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = StockPurchase.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/stockPurchase", produces = {"application/json"})
  ResponseEntity<List<StockPurchase>> listStockPurchase(
      @ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
      @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);

  @ApiOperation(value = "Retrieves a StockPurchase by ID", nickname = "retrieveStockPurchase",
      notes = "This operation retrieves a StockPurchase entity. Attribute selection is enabled for all first level attributes", response = StockPurchase.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = StockPurchase.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/stockPurchase/{id}", produces = {"application/json"})
  ResponseEntity<StockPurchase> listStockPurchase(
      @ApiParam(value = "Identifier of the StockPurchase", required = true) @PathVariable("id") String id,
      @ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);
}