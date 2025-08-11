package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.models.Response;
import com.swapniltiwari.daily_syncup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController
{
   @Autowired
   private TeamService teamService;

   @PostMapping("/create-team")
   public ResponseEntity<Response> createTeam(@RequestBody Team team) {
      return ResponseEntity.ok(new Response(true, "Team created successfully",
              "SUCCESS", HttpStatus.CREATED.value(), teamService.createTeam(team)));
   }

   @GetMapping("/get-teams")
   public ResponseEntity<Response> getTeams() {
      // TODO : will return all teams
      return ResponseEntity.ok(new Response(true, "Teams fetched successfully", null, null, null));
   }

   @GetMapping("/get-team/{id}")
   public ResponseEntity<Response> getTeam(@PathVariable("id") String id) {
      // TODO : will return specific team with its members
      return ResponseEntity.ok(new Response(true, "Team fetched successfully", null, null, null));
   }

   @GetMapping("/get-all-team-members/{id}")
   public ResponseEntity<Response> getAllTeamMembers(@PathVariable("id") String id) {
      // TODO : will return all team members
      return ResponseEntity.ok(new Response(true, "Team members fetched successfully", null, null, null));
   }

   @GetMapping("/get-team-member/{id}")
   public ResponseEntity<Response> getTeamMembers(@PathVariable("id") String id) {
      // TODO : will return specific team members
      return ResponseEntity.ok(new Response(true, "Team members fetched successfully", null, null, null));
   }

   @GetMapping("/teams/{id}/syncups/{date}")
   public ResponseEntity<Response> getTeamSyncups(@PathVariable("id") String id, @PathVariable("date") String date) {
      // TODO : will return all team syncups
      return ResponseEntity.ok(new Response(true, "Team syncups fetched successfully", null, null, null));
   }

   @DeleteMapping("/delete-team/{id}")
   public ResponseEntity<Response> deleteTeam(@PathVariable("id") String id) {
      // TODO : will delete team
      return ResponseEntity.ok(new Response(true, "Team deleted successfully", null, null, null));
   }

   @PutMapping("/update-team/{id}")
   public ResponseEntity<Response> updateTeam(@PathVariable("id") String id){
      // Todo : will update team
      return ResponseEntity.ok(new Response(true, "Team updated successfully", null, null, null));
   }

   @GetMapping("/team/{teamId}/lead")
   public ResponseEntity<Response> getTeamLead(@PathVariable("teamId") String teamId){
      //todo will return team lead
      return ResponseEntity.ok(new Response(true, "Team lead fetched successfully", null, null, null));

   }


}
