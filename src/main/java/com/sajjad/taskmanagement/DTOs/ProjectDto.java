package com.sajjad.taskmanagement.DTOs;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.Project} entity
 */
public record ProjectDto(Integer ID, String name, String description, Integer teamId) implements Serializable {
}