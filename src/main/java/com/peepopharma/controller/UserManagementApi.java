package com.peepopharma.controller;

import com.peepopharma.dto.Error;
import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.InvalidRequestParametersException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Validated
@Api(value = "User", tags = "the User API")
public interface UserManagementApi {

  @ApiOperation(value = "Creates an User", nickname = "createUser",
      notes = "This operation creates an User entity", response = UserDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created", response = UserDto.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PostMapping(value = "/user", produces = {"application/json"}, consumes = {"application/json"})
  ResponseEntity<UserDto> createUser(
      @ApiParam(value = "The User to be created", required = true) @Valid @RequestBody
          UserDto userDto) throws InvalidRequestParametersException;

  @ApiOperation(value = "Deletes an User", nickname = "deleteUser",
      notes = "This operation deletes an User entity")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Deleted"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @DeleteMapping(value = "/user/{id}", produces = {"application/json"})
  ResponseEntity<Void> deleteUser(
      @ApiParam(value = "The identifier of the User", required = true) @PathVariable("id") String id)
      throws EntityNotFoundException;

  @ApiOperation(value = "List or find User objects", nickname = "listUser",
      notes = "This operation lists or finds User entities", response = UserDto.class,
      responseContainer = "List")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = UserDto.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/user", produces = {"application/json"})
  ResponseEntity<Page<UserDto>> listUser(
      @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid
      @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false)
          Integer limit);

  @ApiOperation(value = "Updates partially an User", nickname = "patchUser",
      notes = "This operation updates partially an User entity", response = UserDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Updated", response = UserDto.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PatchMapping(value = "/user/{id}", consumes = {"application/json"}, produces = {"application/json"})
  ResponseEntity<UserDto> patchUser(
      @ApiParam(value = "Identifier of the User", required = true) @PathVariable("id") String id,
      @ApiParam(value = "The User to be updated", required = true) @Valid @RequestBody UserDto userDto)
      throws InvalidRequestParametersException, EntityNotFoundException;

  @ApiOperation(value = "Retrieves an User by ID", nickname = "retrieveUser",
      notes = "This operation retrieves an User entity. Attribute selection is enabled for all first level attributes", response = UserDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = UserDto.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/user/{id}", produces = {"application/json"})
  ResponseEntity<UserDto> listUser(
      @ApiParam(value = "Identifier of the User", required = true) @PathVariable("id") String id)
      throws EntityNotFoundException;

}
