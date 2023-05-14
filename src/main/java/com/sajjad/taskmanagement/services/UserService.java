package com.sajjad.taskmanagement.services;

import com.sajjad.taskmanagement.DTOs.UserDto;
import com.sajjad.taskmanagement.entities.Task;
import com.sajjad.taskmanagement.entities.Team;
import com.sajjad.taskmanagement.entities.User;
import com.sajjad.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setRole(userDto.role());
        return userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public Set<Task> getUserAllTasks(int userID) {
        User user = getUserById(userID);
        return user.getTasks();
    }

    public Set<Team> getUserAllTeams(int userID) {
        User user = getUserById(userID);
        return user.getTeams();
    }
}
