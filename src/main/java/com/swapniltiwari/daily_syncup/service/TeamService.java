package com.swapniltiwari.daily_syncup.service;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import org.springframework.stereotype.Service;

public interface TeamService {

    Object createTeam(Team team);

    void deleteTeam(Long id);

    Object getAllTeams();

    Object getTeamById(Long teamId);

    Object getAllTeamMembers(Long id);

    Object getTeamSyncups(Long id, String date);

    Object updateTeam(Long id, Team team);

    Object getTeamLead(Long teamId);

    Object addMemberToTeam(Long teamId, Member member);
}
