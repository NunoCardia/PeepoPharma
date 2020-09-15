package com.peepopharma.service;

import com.peepopharma.dto.User;
import java.util.List;

public interface UserService {

  User createUser(User user);

  void deleteUser(String id);

  List<User> listUser(String fields, Integer offset, Integer limit);

  User updateUser(String id, UserUpdate user);

  List<User> listUser(String id, String fields);



}
