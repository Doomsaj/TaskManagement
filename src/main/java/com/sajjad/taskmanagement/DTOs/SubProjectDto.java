package com.sajjad.taskmanagement.DTOs;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.SubProject} entity
 */
public record SubProjectDto(String name, Integer projectId) implements Serializable {
}