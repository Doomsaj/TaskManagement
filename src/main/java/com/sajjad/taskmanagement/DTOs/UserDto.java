package com.sajjad.taskmanagement.DTOs;

import com.sajjad.taskmanagement.entities.Team;
import com.sajjad.taskmanagement.entities.User;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
public record UserDto(int id, String name, String email, String password, String role,
                      List<Team> teams) implements Serializable {
}