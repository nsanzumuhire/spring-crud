package com.springcrud.springcrud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    public List<User> findAll();
    public Optional<User> findUserById(UUID id);
    public Optional<User> findUserByEmail(String email);
}
