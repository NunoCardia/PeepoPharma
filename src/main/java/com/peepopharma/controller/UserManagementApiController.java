package com.peepopharma.controller;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.InvalidRequestParametersException;
import com.peepopharma.service.UserApiService;
import com.peepopharma.service.UserService;
import com.peepopharma.validator.UserValidator;
import com.peepopharma.validator.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) throws EntityNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<UserDto>> listUser(@Valid Integer offset, @Valid Integer limit) {
        Page<UserDto> users = userService.listUser(offset, limit);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> patchUser(String id, @Valid UserDto userDto)
        throws InvalidRequestParametersException, EntityNotFoundException {
        userValidator.validate(userDto);
        UserDto updateUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> listUser(String id) throws EntityNotFoundException {
        UserDto user = userService.listUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
