package com.springcrud.springcrud;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    @Override
    public ResponseObjectDto createUser(UserDto userDto) {
        try {
            if (!ObjectUtils.isEmpty(userDto)) {
                User newUser = new User();
                BeanUtils.copyProperties(userDto, newUser);
                return new ResponseObjectDto(userRepository.save(newUser), "User created!");
            }
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public ResponseObjectDto updateUser(UserDto userDto, UUID id) {
        try {
            Optional<User> foundUser = userRepository.findUserById(id);
            if (foundUser.isPresent()) {
                User updatedUser = foundUser.get();
                updatedUser.setName(userDto.getName());
                updatedUser.setEmail(userDto.getEmail());
                updatedUser.setPhone(userDto.getPhone());
                return new ResponseObjectDto(userRepository.save(updatedUser), "User updated");
            } else {
                return new ResponseObjectDto("user not found");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getCause());
        }
    }


}
