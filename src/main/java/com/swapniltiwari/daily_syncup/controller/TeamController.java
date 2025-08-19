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

import java.util.List;

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
           @PathVariable("teamId") Long teamId) {

      log.info("Request received at get-all-team-members API");
      return ResponseEntity.ok(new Response(true,
              "SUCCESS",
              "Team members fetched successfully",
              HttpStatus.OK.value(),
              teamService.getAllTeamMembers(teamId)));
   }


   @DeleteMapping("/{teamId}")
   public ResponseEntity<Response> deleteTeam(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @PathVariable("teamId") Long teamId) {

      log.info("Request received at delete-team API");
      return ResponseEntity.ok(new Response(true,
               "SUCCESS",
               "Team deleted successfully",
               HttpStatus.NO_CONTENT.value(),
               teamService.deleteTeam(teamId)));
   }

   @PutMapping("/{id}")
   public ResponseEntity<Response> updateTeam(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @PathVariable("id") Long id,
            @Valid@RequestBody Team team) {

      log.info("Request received at update-team API");
      return ResponseEntity.ok(new Response(true,
               "SUCCESS",
               "Team updated successfully",
               HttpStatus.OK.value(),
               teamService.updateTeam(id, team)));
   }

   @GetMapping("/{teamId}/{role}")
   public ResponseEntity<Response> getTeamLead(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @PathVariable("teamId") Long teamId,
            @PathVariable("role") String role) {

      log.info("Request received at get-team-lead API");
      return ResponseEntity.ok(new Response(true,
               "SUCCESS",
               "Team lead fetched successfully",
               HttpStatus.OK.value(),
               teamService.getTeamLead(teamId, role)));
   }

   @PostMapping("/{teamId}/members")
   public ResponseEntity<Response> addTeamMember(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @PathVariable("teamId") Long teamId,
            @Valid @RequestBody Member member) {

      log.info("Request Received at add-member-to-team API");
      return ResponseEntity.ok(new Response(true,
               "SUCCESS",
               "Team member added successfully",
               HttpStatus.CREATED.value(),
               teamService.addMemberToTeam(teamId, member)));
   }

   @PostMapping("/{teamId}/addMultipleMembers")
   public ResponseEntity<Response> addMultipleTeamMembers(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @PathVariable("teamId") Long teamId,
            @Valid @RequestBody List<Member> member) {

      log.info("Request received at add-multiple-member-to-team API");
      return ResponseEntity.ok(new Response(true,
               "SUCCESS",
               "Team member added successfully",
               HttpStatus.CREATED.value(),
               teamService.addMultipleMemberToTeam(teamId, member)));
   }
}
