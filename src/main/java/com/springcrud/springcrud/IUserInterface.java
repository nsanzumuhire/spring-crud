package com.springcrud.springcrud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserInterface {
    public List<User> getAll();
    public Optional<User> getUser(UUID id);
    public Optional<User> getUserByEmail(String email);
    public ResponseObjectDto createUser(UserDto userDto);
    public ResponseObjectDto updateUser(UserDto userDto, UUID id);
}
