package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserController {

    private ArrayList<User> users;

    // object of UserController class is created and this constructor is called
    // automatically by spring boot
    UserController() {
        users = new ArrayList<>();
        users.add(new User(1, "Alice", "New York"));
        users.add(new User(2, "Bob", "Los Angeles"));
        users.add(new User(3, "Charlie", "Chicago"));
    };

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // In a real application, consider throwing an exception or returning a 404
                     // status
    }

    @GetMapping("/session-id")
    public String getSessionId(HttpSession session) {
        return session.getId();
    }

    @GetMapping("/users")
    public ArrayList<User> getAllUsers() {
        return users;
    }

    @GetMapping("/home")
    public String greetings() {
        return "Welcome from Spring Boot!";
    }
}
