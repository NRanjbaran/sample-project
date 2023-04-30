package com.demo.serp;

import com.demo.serp.model.Role;
import com.demo.serp.model.User;
import com.demo.serp.model.UserRole;
import com.demo.serp.repository.RoleRepository;
import com.demo.serp.repository.UserRepository;
import com.demo.serp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SerpApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SerpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //initTables();
    }

    private void initTables() {
        // Creating admin user
        User adminUser = new User();
        adminUser.setFirstName("Admin");
        adminUser.setLastName("Admin Admin");
        adminUser.setUsername("admin");
        adminUser.setPassword("1");

        Role role = new Role();
        role.setName("ADMIN");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(adminUser);

        role.getUserRoles().add(userRole);
        adminUser.getUserRoles().add(userRole);

        roleRepository.save(role);
        userRepository.save(adminUser);
        userRoleRepository.save(userRole);
    }
}
