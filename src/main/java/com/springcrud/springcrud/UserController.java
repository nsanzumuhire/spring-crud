package com.springcrud.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    @GetMapping("")
    public List<User> users() {
        return userService.getAll();
    }

    @GetMapping("/id")
    public Optional<User> userbyId(@RequestHeader UUID id) {
        return userService.getUser(id);
    }

    @GetMapping("/email")
    public Optional<User> userbyId(@RequestHeader String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/create-user")
    public ResponseObjectDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/update-user")
    public ResponseObjectDto updateUser(@RequestBody UserDto userDto, @RequestHeader String id) {
        return userService.updateUser(userDto, UUID.fromString(id));
    }
}
