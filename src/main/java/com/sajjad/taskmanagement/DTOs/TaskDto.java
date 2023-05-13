package com.sajjad.taskmanagement.DTOs;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.Task} entity
 */
public class TaskDto implements Serializable {
    private final String name;
    private final String description;
    private final Date due_date;
    private final boolean status;
    private final int user_id;
    private final int sub_project_id;

    public TaskDto(String name, String description, Date due_date, boolean status, int user_id, int sub_project_id) {
        this.name = name;
        this.description = description;
        this.due_date = due_date;
        this.status = status;
        this.user_id = user_id;
        this.sub_project_id = sub_project_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDue_date() {
        return due_date;
    }

    public boolean isStatus() {
        return status;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getSub_project_id() {
        return sub_project_id;
    }
}