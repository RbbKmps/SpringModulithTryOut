package com.modulith.demo.user.core.ports.driving;

import com.modulith.demo.user.core.domain.User;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface UserAPI {
    @Transactional
    User createUser(UserDTO userDTO);

    String getUsernameById(UUID id);

    List<User> getUsers();

    Boolean getUserExists(UUID userId);

    Boolean getUsernameExists(String username);
}
