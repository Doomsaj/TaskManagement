package com.sajjad.taskmanagement.DTOs;

import com.sajjad.taskmanagement.entities.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public class UserDto implements Serializable {
    public UserDto(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private final String name;
    private final String email;
    private final String password;
    private final String role;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}