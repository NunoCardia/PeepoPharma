package com.peepopharma.controller;

import com.peepopharma.dto.Error;
import com.peepopharma.dto.StockPurchaseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import javax.validation.Valid;

@Validated
@Api(value = "StockPurchase", tags = "the StockPurchase API")
public interface StockPurchaseApi {

    @ApiOperation(value = "Creates a StockPurchase", nickname = "createStockPurchase",
        notes = "This operation creates a StockPurchase entity", response = StockPurchaseDto.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = StockPurchaseDto.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @PostMapping(value = "/stockPurchase", produces = {"application/json"}, consumes = {
        "application/json"})
    ResponseEntity<StockPurchaseDto> createStockPurchase(
        @ApiParam(value = "The StockPurchase to be created", required = true) @Valid @RequestBody
            StockPurchaseDto StockPurchaseDto);

    @ApiOperation(value = "Deletes a StockPurchase", nickname = "deleteStockPurchase",
        notes = "This operation deletes a StockPurchase entity")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @DeleteMapping(value = "/stockPurchase/{id}", produces = {"application/json"})
    ResponseEntity<Void> deleteStockPurchase(
        @ApiParam(value = "The identifier of the StockPurchase", required = true) @PathVariable("id") String id);

    @ApiOperation(value = "List or find StockPurchase objects", nickname = "listStockPurchase",
        notes = "This operation lists or finds StockPurchase entities", response = StockPurchaseDto.class,
        responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = StockPurchaseDto.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @GetMapping(value = "/stockPurchase", produces = {"application/json"})
    ResponseEntity<List<StockPurchaseDto>> listStockPurchase(
        @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid
        @RequestParam(value = "offset", required = false) Integer offset,
        @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false)
            Integer limit);

    @ApiOperation(value = "Retrieves a StockPurchase by ID", nickname = "retrieveStockPurchase",
        notes = "This operation retrieves a StockPurchase entity. Attribute selection is enabled for all first level attributes",
        response = StockPurchaseDto.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = StockPurchaseDto.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @GetMapping(value = "/stockPurchase/{id}", produces = {"application/json"})
    ResponseEntity<StockPurchaseDto> listStockPurchase(
        @ApiParam(value = "Identifier of the StockPurchase", required = true) @PathVariable("id") String id);
}
