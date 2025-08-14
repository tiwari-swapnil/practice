package com.swapniltiwari.daily_syncup.service;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface TeamService {

    Object createTeam(Team team);

    Object deleteTeam(Long id);

    Object getAllTeams();

    Object getTeamById(Long teamId);

    Object getAllTeamMembers(Long id);

    Object updateTeam(Long id, Team team);

    Object getTeamLead(Long teamId);

    Object addMemberToTeam(Long teamId, Member member);

    Object addMultipleMemberToTeam(Long teamId, @Valid List<Member> member);
}
