package com.mycompany.taskninja.service;

import com.mycompany.taskninja.domain.Team;
import com.mycompany.taskninja.domain.User;

import java.util.List;

public interface TeamService {
    Team createTeam(Team team);
    Team updateTeam(Team team);
    void deleteTeam(Long teamId);
    Team getTeamById(Long teamId);
    List<Team> getAllTeams();
    List<Team> getTeamsByMember(User member);
}

