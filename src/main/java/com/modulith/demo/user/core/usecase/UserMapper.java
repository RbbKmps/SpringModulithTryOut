package com.modulith.demo.user.core.usecase;

import com.modulith.demo.user.core.domain.User;
import com.modulith.demo.user.core.ports.driving.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDTOToUser(UserDTO userDTO);
}
