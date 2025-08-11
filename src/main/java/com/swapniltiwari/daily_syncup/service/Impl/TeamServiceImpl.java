package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.repositories.TeamRepository;
import com.swapniltiwari.daily_syncup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Object createTeam(Team team) {
        Optional.ofNullable(team).orElseThrow(() -> new BadRequestException("Required values missing"));
        return teamRepository.save(team);
    }
}
