package com.modulith.demo.user.core.ports.driven;

import com.modulith.demo.user.core.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    List<User> findAll();
    void save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
