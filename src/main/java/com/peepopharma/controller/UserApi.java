package com.peepopharma.controller;

import com.peepopharma.dto.User;
import com.peepopharma.dto.UserUpdate;
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
@Api(value = "User", tags = "the User API")
public interface UserApi {


  @ApiOperation(value = "Creates an User", nickname = "createUser",
      notes = "This operation creates an User entity", response = User.class)
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created", response = User.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PostMapping(value = "/user", produces = {"application/json"}, consumes = {"application/json"})
  ResponseEntity<User> createUser(
      @ApiParam(value = "The User to be created", required = true) @Valid @RequestBody
          User userDto);

  @ApiOperation(value = "Deletes an User", nickname = "deleteUser",
      notes = "This operation deletes an User entity")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Deleted"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @DeleteMapping(value = "/user/{id}", produces = {"application/json"})
  ResponseEntity<Void> deleteUser(
      @ApiParam(value = "The identifier of the User", required = true) @PathVariable("id") String id);

  @ApiOperation(value = "List or find User objects", nickname = "listUser",
      notes = "This operation lists or finds User entities", response = User.class,
      responseContainer = "List")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/user", produces = {"application/json"})
  ResponseEntity<List<User>> listUser(
      @ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
      @ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);

  @ApiOperation(value = "Updates partially an User", nickname = "patchUser",
      notes = "This operation updates partially an User entity", response = User.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Updated", response = User.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @PatchMapping(value = "/user/{id}", consumes = {"application/json"}, produces = {
      "application/json"})
  ResponseEntity<User> patchUser(
      @ApiParam(value = "Identifier of the User", required = true) @PathVariable("id") String id,
      @ApiParam(value = "The User to be updated", required = true) @Valid @RequestBody UserUpdate user);


  @ApiOperation(value = "Retrieves an User by ID", nickname = "retrieveUser",
      notes = "This operation retrieves an User entity. Attribute selection is enabled for all first level attributes", response = User.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = User.class),
      @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
      @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
      @ApiResponse(code = 404, message = "Not Found", response = Error.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
  })
  @GetMapping(value = "/user/{id}", produces = {"application/json"})
  ResponseEntity<User> listUser(
      @ApiParam(value = "Identifier of the User", required = true) @PathVariable("id") String id,
      @ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);

}
