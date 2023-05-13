package com.sajjad.taskmanagement.services;

import com.sajjad.taskmanagement.DTOs.TeamDto;
import com.sajjad.taskmanagement.entities.Team;
import com.sajjad.taskmanagement.entities.User;
import com.sajjad.taskmanagement.repositories.TeamRepository;
import com.sajjad.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository teamRepository;

    @Autowired
    private final UserRepository userRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    /**
     * try to find team by id if not found return null
     * @param teamID id of the team that we want
     * @return founded team or null
     */
    public Team getTeamByID(int teamID) {
        return teamRepository.findById(teamID).orElse(null);
    }

    /**
     * Create new Team Throw an exception if user not found in users table.
     * @param teamDto data transfer object for team entity
     * @return newly created team
     */
    public Team createNewTeam(TeamDto teamDto) {
        User teamLead = userRepository.findById(teamDto.getTeamLeadId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        Team newTeam = new Team();
        newTeam.setName(teamDto.getName());
        newTeam.setDescription(teamDto.getDescription());
        newTeam.setTeamLead(teamLead);

        return teamRepository.save(newTeam);
    }

    /**
     * get team all available users
     * @param teamID id of team
     * @return Set of team users
     */
    public Set<User> getTeamUsers(int teamID) {
        Team team = getTeamByID(teamID);
        return team != null ? team.getUsers() : null;
    }

    /**
     * get team team lead
     * @param teamID team id
     * @return team lead user object
     */
    public User getTeamLead(int teamID) {
        Team team = getTeamByID(teamID);
        return team != null ? team.getTeamLead() : null;
    }

    /**
     * change team leader of team
     * @param teamDto data transfer object for team entity {@link com.sajjad.taskmanagement.DTOs.TeamDto}
     * @return team with new team leader user
     */
    public Team changeTeamLead(TeamDto teamDto) {
        Team team = getTeamByID(teamDto.getID());

        User user = userRepository.findById(teamDto.getTeamLeadId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        team.setTeamLead(user);

        return teamRepository.save(team);
    }

    public void deleteTeam(int teamID) {
        teamRepository.deleteById(teamID);
    }
}
