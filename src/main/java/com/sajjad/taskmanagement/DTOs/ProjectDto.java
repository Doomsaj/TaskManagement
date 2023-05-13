package com.sajjad.taskmanagement.DTOs;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.Project} entity
 */
public class ProjectDto implements Serializable {
    private final Integer ID;
    private final String name;
    private final String description;
    private final Integer teamId;

    public ProjectDto(Integer ID, String name, String description, Integer teamId) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.teamId = teamId;
    }


    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTeamId() {
        return teamId;
    }
}