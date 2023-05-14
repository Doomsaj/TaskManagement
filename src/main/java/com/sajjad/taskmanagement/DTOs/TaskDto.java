package com.sajjad.taskmanagement.DTOs;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.Task} entity
 */
public record TaskDto(String name, String description, Date due_date, boolean status, int user_id,
                      int sub_project_id) implements Serializable {
}