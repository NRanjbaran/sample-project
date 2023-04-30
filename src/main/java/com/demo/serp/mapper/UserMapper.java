package com.demo.serp.mapper;

import com.demo.serp.model.User;
import com.demo.serp.model.UserDto;
import org.modelmapper.ModelMapper;

public class UserMapper {

    public static User map(UserDto userDto) {
        // TODO: use injection for model mapper
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }

    public static UserDto map(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDto.class);
    }

}
