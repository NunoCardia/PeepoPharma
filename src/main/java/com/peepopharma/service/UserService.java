package com.peepopharma.service;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.persistence.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

  UserDto createUser(UserDto userDto);

  void deleteUser(String id) throws EntityNotFoundException;

  Page<UserDto> listUser(Integer offset, Integer limit);

  UserDto updateUser(String id, UserDto userDto) throws EntityNotFoundException;

  UserDto listUser(String id) throws EntityNotFoundException;


}
