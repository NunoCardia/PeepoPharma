package com.peepopharma.service;

import com.peepopharma.dto.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserApiService implements UserService{

  @Override
  public User createUser(User user) {
    //validate request body
    return null;
  }

  @Override
  public void deleteUser(String id) {

  }

  @Override
  public List<User> listUser(String fields, Integer offset, Integer limit) {
    return null;
  }

  @Override
  public User updateUser(String id, UserUpdate user) {
    //validate request body
    return null;
  }

  @Override
  public List<User> listUser(String id, String fields) {
    return null;
  }
}
