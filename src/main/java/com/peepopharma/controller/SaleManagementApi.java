package com.peepopharma.controller;

import com.peepopharma.dto.Error;
import com.peepopharma.dto.SaleDto;
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
@Api(value = "Sale", tags = "the Sale API")
public interface SaleManagementApi {

    @ApiOperation(value = "Creates a Sale", nickname = "createSale",
        notes = "This operation creates a Sale entity", response = SaleDto.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = SaleDto.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @PostMapping(value = "/sale", produces = {"application/json"}, consumes = {
        "application/json"})
    ResponseEntity<SaleDto> createSale(
        @ApiParam(value = "The Sale to be created", required = true) @Valid @RequestBody
            SaleDto saleDto);

    @ApiOperation(value = "Deletes a Sale", nickname = "deleteSale",
        notes = "This operation deletes a Sale entity")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @DeleteMapping(value = "/sale/{id}", produces = {"application/json"})
    ResponseEntity<Void> deleteSale(
        @ApiParam(value = "The identifier of the Sale", required = true) @PathVariable("id") String id);

    @ApiOperation(value = "List or find Sale objects", nickname = "listSale",
        notes = "This operation lists or finds Sale entities", response = SaleDto.class,
        responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = SaleDto.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @GetMapping(value = "/sale", produces = {"application/json"})
    ResponseEntity<List<SaleDto>> listSale(
        @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid
        @RequestParam(value = "offset", required = false) Integer offset,
        @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false)
            Integer limit);

    @ApiOperation(value = "Retrieves a Sale by ID", nickname = "retrieveSale",
        notes = "This operation retrieves a Sale entity. Attribute selection is enabled for all first level attributes", response = SaleDto.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = SaleDto.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @GetMapping(value = "/sale/{id}", produces = {"application/json"})
    ResponseEntity<SaleDto> listSale(
        @ApiParam(value = "Identifier of the Sale", required = true) @PathVariable("id") String id);
}
