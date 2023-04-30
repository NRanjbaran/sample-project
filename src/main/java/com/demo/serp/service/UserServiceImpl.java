package com.demo.serp.service;

import com.demo.serp.exception.SerpException;
import com.demo.serp.mapper.UserMapper;
import com.demo.serp.model.User;
import com.demo.serp.model.UserDto;
import com.demo.serp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) throws SerpException {
        validation(userDto);

        User user = UserMapper.map(userDto);
        userRepository.save(user);
        return UserMapper.map(user);
    }

    private void validation(UserDto userDto) throws SerpException {
        Optional<User> localUser = userRepository.findByUsername(userDto.getUsername());
        if (localUser.isPresent()) {
            throw new SerpException("User with this username is exist.");
        }
    }
}
