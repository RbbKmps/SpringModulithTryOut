package com.modulith.demo.user.core.ports.driving;

import com.modulith.demo.user.core.domain.User;
import jakarta.transaction.Transactional;
import java.util.List;

public interface UserAPI {
    @Transactional
    User createUser(UserDTO userDTO);

    String getUsernameById(Long id);

    List<User> getUsers();

    Boolean getUserExists(Long userId);
}
