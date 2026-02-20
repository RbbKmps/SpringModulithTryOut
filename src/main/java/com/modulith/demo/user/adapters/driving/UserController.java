package com.modulith.demo.user.adapters.driving;

import com.modulith.demo.user.core.ports.driving.UserDTO;
import com.modulith.demo.user.core.domain.User;
import com.modulith.demo.user.core.usecase.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }
}
