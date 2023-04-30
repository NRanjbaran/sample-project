package com.demo.serp.controller;

import com.demo.serp.exception.SerpException;
import com.demo.serp.model.RoleDto;
import com.demo.serp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(path = "/create-role")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) throws SerpException {
        RoleDto role = this.roleService.createRole(roleDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(role);
    }

}
