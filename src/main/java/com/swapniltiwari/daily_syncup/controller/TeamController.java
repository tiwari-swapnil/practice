package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController
{
   @PostMapping("/create-team")
   public ResponseEntity<Response> createTeam() {
      // TODO : will create team
      return ResponseEntity.ok(new Response(true, "Team created successfully", null, null, null));
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
}
