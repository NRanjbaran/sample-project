package com.demo.serp.service;

import com.demo.serp.exception.SerpException;
import com.demo.serp.model.RoleDto;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto) throws SerpException;

}
