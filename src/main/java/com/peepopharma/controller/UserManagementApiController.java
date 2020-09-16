package com.peepopharma.controller;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.InvalidRequestParametersException;
import com.peepopharma.service.UserApiService;
import com.peepopharma.service.UserService;
import com.peepopharma.validator.UserValidator;
import com.peepopharma.validator.Validator;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pharma-api/userManagement/v1/")
@Slf4j
public class UserManagementApiController implements UserManagementApi {

  private final UserService userService;
  private final Validator<UserDto> userValidator;

  public UserManagementApiController(UserApiService userService,
      UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
  }

  @Override
  public ResponseEntity<UserDto> createUser(@Valid UserDto userDto)
      throws InvalidRequestParametersException {
    userValidator.validate(userDto);
    UserDto user = userService.createUser(userDto);
    log.info("User added: {}", user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(String id) throws EntityNotFoundException {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<UserDto>> listUser(@Valid String fields, @Valid Integer offset,
      @Valid Integer limit) {
    return null;
  }

  @Override
  public ResponseEntity<UserDto> patchUser(String id, @Valid UserDto userDto) {
    //validate request body
    return null;
  }

  @Override
  public ResponseEntity<UserDto> listUser(String id, @Valid String fields) {
    return null;
  }
}
