package com.sajjad.taskmanagement.services;

import com.sajjad.taskmanagement.DTOs.TaskDto;
import com.sajjad.taskmanagement.entities.SubProject;
import com.sajjad.taskmanagement.entities.Task;
import com.sajjad.taskmanagement.entities.User;
import com.sajjad.taskmanagement.repositories.SubProjectRepository;
import com.sajjad.taskmanagement.repositories.TaskRepository;
import com.sajjad.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SubProjectRepository subProjectRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, SubProjectRepository subProjectRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.subProjectRepository = subProjectRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(TaskDto taskDto) {
        User user = userRepository.findById(taskDto.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        SubProject subProject = subProjectRepository.findById(taskDto.getSub_project_id())
                .orElseThrow(() -> new RuntimeException("Sub project not found"));

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDue_date(taskDto.getDue_date());
        task.setStatus(false);
        task.setUser(user);
        task.setSubProject(subProject);
        return taskRepository.save(task);
    }

    public boolean changeTaskStatus(int id) {
        Task task = getTaskById(id);
        if (task != null && !task.isStatus()) {
            task.setStatus(true);
            return true;
        } else {
            return false;
        }
    }

    public User getTaskUser(int taskID) {
        Task task = getTaskById(taskID);
        return task == null ? null : task.getUser();
    }

    public void deleteTask(int taskID) {
        taskRepository.deleteById(taskID);
    }
}
