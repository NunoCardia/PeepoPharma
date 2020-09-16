package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.UserDto;
import com.peepopharma.persistence.model.User;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface UserMapper {

  UserDto fromUserModel (User user);

  User fromUserDto(UserDto userDto);
}
