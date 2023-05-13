package com.sajjad.taskmanagement.DTOs;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.SubProject} entity
 */
public class SubProjectDto implements Serializable {
    private final String name;
    private final Integer projectId;

    public SubProjectDto(String name, Integer projectId) {
        this.name = name;
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public Integer getProjectId() {
        return projectId;
    }
}