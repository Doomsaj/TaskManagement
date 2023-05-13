package com.sajjad.taskmanagement.DTOs;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sajjad.taskmanagement.entities.Team} entity
 */
public class TeamDto implements Serializable {
    private final Integer ID;
    private final String name;
    private final String description;
    private final Integer teamLeadId;

    public TeamDto(Integer ID, String name, String description, Integer teamLeadId) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.teamLeadId = teamLeadId;
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

    public Integer getTeamLeadId() {
        return teamLeadId;
    }
}