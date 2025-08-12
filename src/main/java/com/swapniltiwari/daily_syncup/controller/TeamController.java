package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.constants.Constant;
import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import com.swapniltiwari.daily_syncup.models.Response;
import com.swapniltiwari.daily_syncup.service.TeamService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamController {

   @Autowired
   private TeamService teamService;

   @PostMapping(value = "/createTeam", consumes = Constant.APPLICATION_JSON, produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> createTeam(
           @RequestHeader(HttpHeaders.ACCEPT) String accept,
           @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
           @RequestBody Team team) {
      log.info("Request received at create-team API");
      return ResponseEntity.ok(new Response(
              true,
              "SUCCESS",
              "Team created successfully",
              HttpStatus.CREATED.value(),
              teamService.createTeam(team)
      ));
   }

   @GetMapping(value = "", consumes = Constant.APPLICATION_JSON, produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> getTeams(
           @RequestHeader(HttpHeaders.ACCEPT) String accept,
           @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType) {

      log.info("Request received at get-all-teams API");
      return ResponseEntity.ok(new Response(
              true,
              "SUCCESS",
              "All teams fetched successfully",
              HttpStatus.OK.value(),
              teamService.getAllTeams()));
   }

   @GetMapping("/{teamId}")
   public ResponseEntity<Response> getTeam(
           @RequestHeader(HttpHeaders.ACCEPT) String accept,
           @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
           @PathVariable("teamId") Long teamId) {

      log.info("Request received at get-specific-team API");
      return ResponseEntity.ok(new Response(true,
              "SUCCESS",
              "Team fetched successfully",
              HttpStatus.OK.value(),
              teamService.getTeamById(teamId)));
   }

   @GetMapping("/{id}/members")
   public ResponseEntity<Response> getAllTeamMembers(
           @RequestHeader(HttpHeaders.ACCEPT) String accept,
           @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
           @PathVariable("id") Long id) {

      log.info("Request received at get-all-team-members API");
      return ResponseEntity.ok(new Response(true,
              "SUCCESS",
              "Team members fetched successfully",
              HttpStatus.OK.value(),
              teamService.getAllTeamMembers(id)));
   }


   @GetMapping("/{id}/syncups/{date}")
   public ResponseEntity<Response> getTeamSyncups(@PathVariable("id") Long id, @PathVariable("date") String date) {
      return ResponseEntity.ok(new Response(true, "Team syncups fetched successfully", null, null, teamService.getTeamSyncups(id, date)));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Response> deleteTeam(@PathVariable("id") Long id) {
      teamService.deleteTeam(id);
      return ResponseEntity.ok(new Response(true, "Team deleted successfully", null, null, null));
   }

   @PutMapping("/{id}")
   public ResponseEntity<Response> updateTeam(@PathVariable("id") Long id, @RequestBody Team team) {
      return ResponseEntity.ok(new Response(true, "Team updated successfully", null, null, teamService.updateTeam(id, team)));
   }

   @GetMapping("/{teamId}/lead")
   public ResponseEntity<Response> getTeamLead(@PathVariable("teamId") Long teamId) {
      return ResponseEntity.ok(new Response(true, "Team lead fetched successfully", null, null, teamService.getTeamLead(teamId)));
   }

   @PostMapping("/{teamId}/members")
   public ResponseEntity<Response> addTeamMember(@PathVariable("teamId") Long teamId, @RequestBody Member member) {
      return ResponseEntity.ok(new Response(true, "Team member added successfully", null, null, teamService.addMemberToTeam(teamId, member)));
   }
}
