package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.exceptions.ResourceNotFoundException;
import com.swapniltiwari.daily_syncup.repositories.TeamRepository;
import com.swapniltiwari.daily_syncup.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Object createTeam(Team team) {
        try {
            if (teamRepository.existsByTeamNameIgnoreCase(team.getTeamName())) {
                throw new BadRequestException("Team name already exists");
            }

            log.info("Saving the team details to db");
            return teamRepository.save(team);
        } catch (Exception e) {
            log.error("Exception occurred while creating team : ", e);
            throw e;
        }
    }


    @Override
    public List<Team> getAllTeams() {
        try{
            return teamRepository.findByIsDeletedFalse();
        }catch (Exception e){
            log.error("Exception occurred while fetching all the teams : ", e);
            throw e;
        }
    }

    @Override
    public Object getTeamById(Long teamId) {
        try{
            return teamRepository.findByIdAndIsDeletedFalse(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));        } catch (Exception e) {
            log.error("Exception occurred while fetching specific team : ", e);
            throw e;
        }
    }

    @Override
    public Object getAllTeamMembers(Long id) {
        try{
            return teamRepository.findByTeamIdAndIsDeletedFalse(id);
        } catch (Exception e) {
            log.error("Exception occurred while fetching all the team members : ", e);
            throw e;
        }
    }

    @Override
    public Object getTeamSyncups(Long id, String date) {
        return null;
    }

    @Override
    public Object updateTeam(Long id, Team team) {
        return null;
    }

    @Override
    public Object getTeamLead(Long teamId) {
        return null;
    }

    @Override
    public Object addMemberToTeam(Long teamId, Member member) {
        return null;
    }

    @Override
    public void deleteTeam(Long id) {

    }


}
