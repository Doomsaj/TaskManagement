package com.sajjad.taskmanagement.DTOs;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.Team} entity
 */
public record TeamDto(Integer ID, String name, String description, Integer teamLeadId) implements Serializable {
}