package com.modulith.demo.user.core.usecase;

import com.modulith.demo.user.core.ports.driven.UserPersistencePort;
import com.modulith.demo.user.core.ports.driving.UserAPI;
import com.modulith.demo.user.core.ports.driving.UserDTO;
import com.modulith.demo.user.core.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserAPI {
    private final UserPersistencePort userPersistencePort;

    public UserService(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        Optional<User> existingUser = userPersistencePort.findByEmail(userDTO.email());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("There is already a user with the email " + userDTO.email());
        }

        User user = new User();
        user.setEmail(userDTO.email());
        user.setUsername(userDTO.username());
        userPersistencePort.save(user);
        return user;
    }

    @Override
    public String getUsernameById(Long id) {
        Optional<User> user = userPersistencePort.findById(id);
        if (user.isPresent()) {
            return user.get().getUsername();
        }
        throw new RuntimeException("User with id " + id + " not found");
    }

    @Override
    public List<User> getUsers() {
        return userPersistencePort.findAll();
    }

    @Override
    public Boolean getUserExists(Long userId) {
        return userPersistencePort.findById(userId).isPresent();
    }

    @Override
    public Boolean getUsernameExists(String username) {
        return userPersistencePort.findByUsername(username).isPresent();
    }
}
