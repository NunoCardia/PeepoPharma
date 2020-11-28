package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.UserDto;
import com.peepopharma.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public interface UserMapper {

  UserDto fromUserModel(User user);

  @Mapping(target = "role", expression = "java(com.peepopharma.persistence.model.Role.fromValue(userDto.getRole()))")
  User fromUserDto(UserDto userDto);

  List<UserDto> fromUserModelList(List<User> users);
}
