package com.modulith.demo.post.adapters.driven;

import com.modulith.demo.post.core.ports.driven.UserLookupPort;
import com.modulith.demo.user.core.ports.driving.UserAPI;
import org.springframework.stereotype.Component;

@Component("postUserLookupAdapter")
public class UserLookupAdapter implements UserLookupPort {
    private final UserAPI userAPI;

    public UserLookupAdapter(UserAPI userAPI) {
        this.userAPI = userAPI;
    }

    @Override
    public Boolean userExists(Long userId) {
        return userAPI.getUserExists(userId);
    }

    @Override
    public Boolean usernameExists(String username) {
        return userAPI.getUsernameExists(username);
    }
}
