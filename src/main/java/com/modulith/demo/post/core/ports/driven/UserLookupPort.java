package com.modulith.demo.post.core.ports.driven;

public interface UserLookupPort {
    Boolean userExists(Long userId);
    Boolean usernameExists(String username);
}
