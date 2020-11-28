package com.peepopharma.service;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.ErrorMessage;
import com.peepopharma.mapper.UserMapper;
import com.peepopharma.persistence.model.User;
import com.peepopharma.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserApiService implements UserService {

    static final String USER_FOUND_FOR_ID = "User found for id {}";
    static final String USER_NOT_FOUND_FOR_ID = "User not found for id {}";
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
            log.debug(USER_FOUND_FOR_ID, id);
            userRepository.delete(optionalUser.get());
        } else {
            log.error(USER_NOT_FOUND_FOR_ID, id);
            throw new EntityNotFoundException(
                String.format(ErrorMessage.ENTITY_NOT_FOUND, User.class.getSimpleName(), id));
        }
    }

    @Override
    public Page<UserDto> listUser(Integer offset, Integer limit) {
        PageRequest request = PageRequest.of(offset, limit);
        Page<User> users = userRepository.findAll(request);
        return new PageImpl<>(userMapper.fromUserModelList(users.getContent()), request,
                              users.getTotalElements());

    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            log.debug(USER_FOUND_FOR_ID, id);
            User userModel = userMapper.fromUserDto(userDto);
            return userMapper.fromUserModel(userRepository.save(userModel));
        }
        log.error(USER_NOT_FOUND_FOR_ID, id);
        throw new EntityNotFoundException(
            String.format(ErrorMessage.ENTITY_NOT_FOUND, User.class.getSimpleName(), id));
    }

    @Override
    public UserDto listUser(String id) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            log.debug(USER_FOUND_FOR_ID, id);
            return userMapper.fromUserModel(optionalUser.get());
        }
        log.error(USER_NOT_FOUND_FOR_ID, id);
        throw new EntityNotFoundException(
            String.format(ErrorMessage.ENTITY_NOT_FOUND, User.class.getSimpleName(), id));
    }
}
