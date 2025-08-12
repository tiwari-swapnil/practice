package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.repositories.TeamRepository;
import com.swapniltiwari.daily_syncup.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Object createTeam(Team team) {
        Optional.ofNullable(team.getTeamName())
                 .filter(StringUtils::isNotEmpty)
                 .orElseThrow(() -> new BadRequestException("Invalid request,required parameters are missing"));
        log.info("Saving the team details to db");
        return teamRepository.save(team);
    }
}
