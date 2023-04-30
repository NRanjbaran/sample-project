package com.demo.serp.service;

import com.demo.serp.exception.SerpException;
import com.demo.serp.model.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto) throws SerpException;
}
