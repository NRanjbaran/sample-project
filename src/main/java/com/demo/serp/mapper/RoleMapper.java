package com.demo.serp.mapper;

import com.demo.serp.model.Role;
import com.demo.serp.model.RoleDto;
import org.modelmapper.ModelMapper;

public class RoleMapper {

    public static Role map(RoleDto roleDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(roleDto, Role.class);
    }

    public static RoleDto map(Role role) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(role, RoleDto.class);
    }
}
