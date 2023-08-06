package com.mycompany.taskninja.impl;

import com.mycompany.taskninja.domain.Team;
import com.mycompany.taskninja.domain.User;
import com.mycompany.taskninja.repository.TeamRepository;
import com.mycompany.taskninja.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> getTeamsByMember(User member) {
        return teamRepository.findByMembers(member);
    }
}

