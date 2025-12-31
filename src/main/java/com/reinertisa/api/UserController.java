package com.reinertisa.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/{version}/users", version = "1.0")
    public List<UserDTOv1> findAllUserV1() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toV1)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/users", version = "1.1")
    public List<UserDTOv1>  findAllUser1_1() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toV1)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{version}/users", version = "2.0")
    public List<UserDTOv2> findAllUserV2() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toV2)
                .collect(Collectors.toList());
    }
}
