package com.modulith.demo.notification.adapters.driven;

import com.modulith.demo.notification.core.ports.driven.UserLookupPort;
import com.modulith.demo.user.core.ports.driving.UserAPI;
import org.springframework.stereotype.Component;

@Component("notificationUserLookupAdapter")
public class UserLookupAdapter implements UserLookupPort {
    private final UserAPI userAPI;

    public UserLookupAdapter(UserAPI userAPI) {
        this.userAPI = userAPI;
    }

    @Override
    public String getUsernameById(Long userId) {
        return userAPI.getUsernameById(userId);
    }
}
