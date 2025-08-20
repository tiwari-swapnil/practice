package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.exceptions.InvalidOperationException;
import com.swapniltiwari.daily_syncup.exceptions.ResourceNotFoundException;
import com.swapniltiwari.daily_syncup.helper.HelperMethods;
import com.swapniltiwari.daily_syncup.repositories.MemberRepository;
import com.swapniltiwari.daily_syncup.repositories.TeamRepository;
import com.swapniltiwari.daily_syncup.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HelperMethods helperMethods;

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
            Optional<Team> optionalTeam = teamRepository.findByTeamIdAndIsDeletedFalse(id);

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
    public List<Member> getMemberBasedOnRole(Long teamId, String role) {
        try {
            log.info("Getting team role ");

            teamRepository.findByTeamIdAndIsDeletedFalse(teamId)
                    .orElseThrow(()-> new ResourceNotFoundException( "Team not found with id: " + teamId));

            role = helperMethods.getRoleValue(role);

            return memberRepository
                     .findByTeam_TeamIdAndRoleAndIsDeletedFalse(teamId, role);

        } catch (Exception e) {
            log.error("Exception occurred while fetching team lead for teamId {}: ", teamId, e);
            throw e;
        }
    }


    @Override
    public String addMemberToTeam(Long teamId, Member member) {
        try {
            Team team = teamRepository.findByTeamIdAndIsDeletedFalse(teamId)
                     .orElseThrow(() -> new ResourceNotFoundException(
                              "Team not found with id: " + teamId));

            if(Objects.isNull(member)){
                throw new BadRequestException("Member is null");
            }

            log.info("Adding member to the team");
            member.setIsDeleted(false);
            member.setTeam(team);

            member.setRole(helperMethods.getRoleValue(member.getRole()));
            Set<Member> members = team.getMembers();
            members.add(member);
            team.setIsDeleted(false);
            teamRepository.save(team);
            log.info("Member added successfully to team");
            return team.getTeamName();

        } catch (Exception e) {
            log.error("Exception occurred while adding member to team with id {}: ", teamId, e);
            throw e;
        }
    }

    @Override
    public Object addMultipleMemberToTeam(Long teamId, List<Member> member)
    {
        try{
            Team team = teamRepository.findByTeamIdAndIsDeletedFalse(teamId)
                     .orElseThrow(() -> new ResourceNotFoundException(
                              "Team not found with id: " + teamId));

            if (member == null || member.isEmpty()) {
                throw new BadRequestException("Members are null ");
            }

            log.info("Adding members to the team");

            member.forEach((m)-> {
                m.setIsDeleted(false);
                m.setTeam(team);
                m.setRole(helperMethods.getRoleValue(m.getRole()));
                team.getMembers().add(m);
                team.setIsDeleted(false);
                teamRepository.save(team);
            });

            log.info("All members added successfully ");
            return true;

        }
        catch (Exception e){
            log.error("Exception occurred while adding multiple member to team with id {}: ", teamId, e);
            throw e;
        }
    }

    @Override
    public Object toggleMemberScrumMaster(Long teamId, Long memberId, String isScrumMaster)
    {
        try{
            System.out.println("Is scrum master: " + isScrumMaster);
            Member member = memberRepository.findByMemberIdAndIsDeletedFalse(memberId).orElseThrow(
                     () -> new ResourceNotFoundException("Member not found with id: " + memberId));

            if(member.getTeam() == null ){
                throw new InvalidOperationException("Cannot make member scrum master, as member is not part of any team");
            }
           member.setIsScrumMaster(Boolean.parseBoolean(isScrumMaster));
           memberRepository.save(member);
            return true;
        }
        catch (Exception e){
            log.error("Exception occurred while adding multiple member to team with id {}: ", teamId, e);
            throw e;
        }
    }

    @Override
    public Object deleteTeam(Long id) {
        try{
            Optional<Team> optionalTeam = teamRepository.findByTeamIdAndIsDeletedFalse(id);
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
