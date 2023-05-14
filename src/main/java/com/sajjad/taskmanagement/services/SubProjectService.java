package com.sajjad.taskmanagement.services;

import com.sajjad.taskmanagement.DTOs.SubProjectDto;
import com.sajjad.taskmanagement.entities.Project;
import com.sajjad.taskmanagement.entities.SubProject;
import com.sajjad.taskmanagement.entities.Task;
import com.sajjad.taskmanagement.repositories.ProjectRepository;
import com.sajjad.taskmanagement.repositories.SubProjectRepository;
import com.sajjad.taskmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubProjectService {
    @Autowired
    private final SubProjectRepository subProjectRepository;

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final TaskRepository taskRepository;

    public SubProjectService(SubProjectRepository subProjectRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.subProjectRepository = subProjectRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public SubProject getSubProjectByID(int subProjectID) {
        return subProjectRepository.findById(subProjectID).orElse(null);
    }

    public SubProject createSubProject(SubProjectDto subProjectDto) {
        Project project = projectRepository.findById(subProjectDto.projectId())
                .orElseThrow(() -> new RuntimeException("project not found"));

        SubProject newSubProject = new SubProject();
        newSubProject.setName(subProjectDto.name());
        newSubProject.setProject(project);

        return subProjectRepository.save(newSubProject);
    }

    public void deleteSubProject(int ID) {
        subProjectRepository.deleteById(ID);
    }

    public Set<Task> getAllTasks(int ID) {
        SubProject subProject = getSubProjectByID(ID);
        return subProject != null ? subProject.getTasks() : null;
    }
}
