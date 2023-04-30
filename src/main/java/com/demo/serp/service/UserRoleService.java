package com.demo.serp.service;

import com.demo.serp.exception.SerpException;
import com.demo.serp.model.RoleDto;
import com.demo.serp.model.UserDto;

public interface UserRoleService {

    void assignRoleToUser(RoleDto roleDto, UserDto userDto) throws SerpException;
}
