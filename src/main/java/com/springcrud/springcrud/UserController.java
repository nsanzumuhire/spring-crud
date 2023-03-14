package com.springcrud.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
