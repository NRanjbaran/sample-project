package com.demo.serp.service;

import com.demo.serp.exception.SerpException;
import com.demo.serp.model.Role;
import com.demo.serp.model.RoleDto;
import com.demo.serp.model.User;
import com.demo.serp.model.UserDto;
import com.demo.serp.model.UserRole;
import com.demo.serp.repository.RoleRepository;
import com.demo.serp.repository.UserRepository;
import com.demo.serp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void assignRoleToUser(RoleDto roleDto, UserDto userDto) throws SerpException {
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        Optional<Role> role = roleRepository.findByName(roleDto.getName());
        if (user.isEmpty()) {
            throw new SerpException("User not found.");
        }
        if (role.isEmpty()) {
            throw new SerpException("Role not found.");
        }

        UserRole userRole = new UserRole(user.get(), role.get());
        userRoleRepository.save(userRole);

        /*user.get().getUserRoles().add(userRole);
        role.get().getUserRoles().add(userRole);

        userRepository.save(user.get());
        roleRepository.save(role.get());*/
    }
}
