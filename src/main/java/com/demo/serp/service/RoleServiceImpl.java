package com.demo.serp.service;

import com.demo.serp.exception.SerpException;
import com.demo.serp.mapper.RoleMapper;
import com.demo.serp.model.Role;
import com.demo.serp.model.RoleDto;
import com.demo.serp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto createRole(RoleDto roleDto) throws SerpException {
        validation(roleDto);

        Role role = RoleMapper.map(roleDto);
        roleRepository.save(role);

        return RoleMapper.map(role);
    }

    private void validation(RoleDto roleDto) throws SerpException {
        Optional<Role> role = roleRepository.findByName(roleDto.getName());
        if (role.isPresent()) {
            throw new SerpException("Role with this name is exists.");
        }
    }

}
