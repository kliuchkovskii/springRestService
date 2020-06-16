package com.portfolio.service;

import com.portfolio.app.PortfolioApplication;
import com.portfolio.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "id") Long id){
        return users.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        user.setId(System.currentTimeMillis());
        users.add(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        users.add(new User(5L, "34f", "fewe", 54));
        return users;
    }
}
