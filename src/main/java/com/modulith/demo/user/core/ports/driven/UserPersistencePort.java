package com.modulith.demo.user.core.ports.driven;

import com.modulith.demo.user.core.domain.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPersistencePort {
    List<User> findAll();

    void save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
