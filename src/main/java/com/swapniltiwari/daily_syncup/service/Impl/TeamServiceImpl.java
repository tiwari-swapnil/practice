package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.enums.Role;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.exceptions.ResourceNotFoundException;
import com.swapniltiwari.daily_syncup.repositories.TeamRepository;
import com.swapniltiwari.daily_syncup.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            return teamRepository.findByTeamIdAndIsDeletedFalse(teamId)
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
    public Team updateTeam(Long id, Team team) {
        try {
            Optional<Team> optionalTeam = teamRepository.findByIdAndIsDeletedFalse(id);

            if (optionalTeam.isEmpty()) {
                log.info("Team not found with id: {}", id);
                throw new ResourceNotFoundException("Team not found with id: " + id);
            }

            Team existingTeam = optionalTeam.get();

            // Check if new team name already exists (case-insensitive)
            if (teamRepository.existsByTeamNameIgnoreCase(team.getTeamName())
                     && !existingTeam.getTeamName().equalsIgnoreCase(team.getTeamName())) {
                throw new IllegalArgumentException("Team name already exists: " + team.getTeamName());
            }

            existingTeam.setTeamName(team.getTeamName());
            existingTeam.setIsDeleted(false);
            existingTeam.setMembers(team.getMembers());

            Team updatedTeam = teamRepository.save(existingTeam);
            log.info("Team updated successfully with id: {}", id);

            return updatedTeam;

        } catch (Exception e) {
            log.error("Exception occurred while updating team: ", e);
            throw e;
        }
    }


    @Override
    public Member getTeamLead(Long teamId) {
        try {
            return teamRepository
                     .findByTeam_TeamIdAndRoleAndIsDeletedFalse(teamId, Role.TEAM_LEAD.getMessage())
                     .orElseThrow(() -> new ResourceNotFoundException(
                              "Team lead not found for team with id: " + teamId));
        } catch (Exception e) {
            log.error("Exception occurred while fetching team lead for teamId {}: ", teamId, e);
            throw e;
        }
    }


    @Override
    public Team addMemberToTeam(Long teamId, Member member) {
        try {
            Team team = teamRepository.findByIdAndIsDeletedFalse(teamId)
                     .orElseThrow(() -> new ResourceNotFoundException(
                              "Team not found with id: " + teamId));

            team.getMembers().add(member);
            return teamRepository.save(team);

        } catch (Exception e) {
            log.error("Exception occurred while adding member to team with id {}: ", teamId, e);
            throw e;
        }
    }

    @Override
    public Object addMultipleMemberToTeam(Long teamId, List<Member> member)
    {
        try{
            Team team = teamRepository.findByIdAndIsDeletedFalse(teamId)
                     .orElseThrow(() -> new ResourceNotFoundException(
                              "Team not found with id: " + teamId));

            if (member != null && !member.isEmpty()) {
                team.getMembers().addAll(member);
                return teamRepository.save(team);
            }

            return null;
        }
        catch (Exception e){
            log.error("Exception occurred while adding multiple member to team with id {}: ", teamId, e);
            throw e;
        }
    }

    @Override
    public Object deleteTeam(Long id) {
        try{
            Optional<Team> optionalTeam = teamRepository.findByIdAndIsDeletedFalse(id);
            if(optionalTeam.isPresent()){
                Team team = optionalTeam.get();
                team.setIsDeleted(true);
                teamRepository.save(team);
            }
            return null;
        }
        catch (Exception e) {
            log.error("Exception occurred while deleting team : ", e);
            throw e;
        }
    }


}
