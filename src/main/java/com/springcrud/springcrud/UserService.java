package com.springcrud.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserInterface {

    @Autowired IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return userRepository.findUserById(id);
    }

    @Override
    public  Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
