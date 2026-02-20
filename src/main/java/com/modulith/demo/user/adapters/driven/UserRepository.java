package com.modulith.demo.user.adapters.driven;

import com.modulith.demo.user.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
