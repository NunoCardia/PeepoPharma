package com.peepopharma.service;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.ErrorMessage;
import com.peepopharma.mapper.UserMapper;
import com.peepopharma.persistence.model.User;
import com.peepopharma.persistence.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserApiService implements UserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;

  public UserApiService(UserMapper userMapper,
      UserRepository userRepository) {
    this.userMapper = userMapper;
    this.userRepository = userRepository;
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    User userModel = userRepository.save(userMapper.fromUserDto(userDto));
    log.debug("Saved user: {}", userModel);
    return userMapper.fromUserModel(userModel);
  }

  @Override
  public void deleteUser(String id) throws EntityNotFoundException {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      log.debug("User found for id {}", id);
      userRepository.delete(optionalUser.get());
    } else {
      log.debug("User not found for id {}", id);
      throw new EntityNotFoundException(
          String.format(ErrorMessage.ENTITY_NOT_FOUND, User.class.getSimpleName(), id));
    }
  }

  @Override
  public List<UserDto> listUser(String fields, Integer offset, Integer limit) {
    return null;
  }

  @Override
  public UserDto updateUser(String id, UserDto userDto) {
    //validate request body
    return null;
  }

  @Override
  public List<UserDto> listUser(String id, String fields) {
    return null;
  }
}
