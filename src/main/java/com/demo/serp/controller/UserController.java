package com.demo.serp.controller;

import com.demo.serp.exception.SerpException;
import com.demo.serp.model.RoleDto;
import com.demo.serp.model.UserDto;
import com.demo.serp.service.UserRoleService;
import com.demo.serp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping(path = "/create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws SerpException {
        UserDto user = userService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @PutMapping(path = "/assign")
    public ResponseEntity<UserDto> assignUserRole(@RequestBody UserDto userDto, @RequestBody RoleDto roleDto) throws SerpException {
        this.userRoleService.assignRoleToUser(roleDto, userDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
