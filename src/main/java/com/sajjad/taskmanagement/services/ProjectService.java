package com.sajjad.taskmanagement.services;

import com.sajjad.taskmanagement.DTOs.ProjectDto;
import com.sajjad.taskmanagement.entities.Project;
import com.sajjad.taskmanagement.entities.Team;
import com.sajjad.taskmanagement.repositories.ProjectRepository;
import com.sajjad.taskmanagement.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final TeamRepository teamRepository;

    public ProjectService(ProjectRepository projectRepository, TeamRepository teamRepository) {
        this.projectRepository = projectRepository;
        this.teamRepository = teamRepository;
    }

    /**
     * get project by id
     * @param projectID project ID
     * @return founded project or null
     */
    public Project getProjectByID(int projectID) {
        return projectRepository.findById(projectID).orElse(null);
    }

    /**
     * create new project
     * @param projectDto data transfer object for project entity
     * @return newly created project
     */
    public Project createNewProject(ProjectDto projectDto) {
        Team team = teamRepository.findById(projectDto.getTeamId())
                .orElseThrow(() -> new RuntimeException("team not found"));

        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setTeam(team);
        return projectRepository.save(project);
    }

    /**
     * delete project by given projectID
     * @param projectID project id
     */
    public void deleteProject(int projectID) {
        projectRepository.deleteById(projectID);
    }
}
