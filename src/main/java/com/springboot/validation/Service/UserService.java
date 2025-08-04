package com.springboot.validation.Service;

import com.springboot.validation.Model.User;
import com.springboot.validation.Repository.ValidationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private ValidationRepo validationRepo;

    public User addUser(User user) {
        if (validationRepo.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("Email already exists");
        }
        return validationRepo.save(user);
    }

    public List<User> getAllUsers() {
        return validationRepo.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        return validationRepo.findByEmail(email.toLowerCase().trim());
    }

    public void updateUser(String email, User updatedUser) {
        if (updatedUser == null) {
            throw new IllegalArgumentException("Updated user data must not be null");
        }

        User existingUser = validationRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setPhone(updatedUser.getPhone());

        validationRepo.save(existingUser);
    }

    public boolean deleteUserByEmail(String email) {
        long deletedCount = validationRepo.deleteByEmail(email);
        return deletedCount > 0;
    }

    public boolean emailExists(String email) {
        return validationRepo.existsByEmail(email);
    }
}
