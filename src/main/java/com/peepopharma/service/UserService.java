package com.peepopharma.service;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import java.util.List;

public interface UserService {

  UserDto createUser(UserDto userDto);

  void deleteUser(String id) throws EntityNotFoundException;

  List<UserDto> listUser(String fields, Integer offset, Integer limit);

  UserDto updateUser(String id, UserDto userDto);

  List<UserDto> listUser(String id, String fields);



}
