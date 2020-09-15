package com.peepopharma.controller;

import com.peepopharma.dto.User;
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
  private final Validator<User> userValidator;

  public UserManagementApiController(UserApiService userService,
      UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
  }

  @Override
  public ResponseEntity<User> createUser(@Valid User userDto)
      throws InvalidRequestParametersException {
    userValidator.validate(userDto);
    User user = userService.createUser(userDto);
    log.info("User added: {}", user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(String id) {
    return null;
  }

  @Override
  public ResponseEntity<List<User>> listUser(@Valid String fields, @Valid Integer offset,
      @Valid Integer limit) {
    return null;
  }

  @Override
  public ResponseEntity<User> patchUser(String id, @Valid User user) {
    //validate request body
    return null;
  }

  @Override
  public ResponseEntity<User> listUser(String id, @Valid String fields) {
    return null;
  }
}
