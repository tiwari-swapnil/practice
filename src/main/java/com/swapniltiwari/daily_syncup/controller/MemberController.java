package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.constants.Constant;
import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.models.Response;
import com.swapniltiwari.daily_syncup.service.MemberService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController
{
   @Autowired
   private MemberService memberService;

   @PostMapping(value = "/createMember",
            consumes = Constant.APPLICATION_JSON,
            produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> createMember(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @Valid @RequestBody Member member
   )
   {
      log.info("Request Received to create member, creating member...");
      return ResponseEntity.ok(new Response(true,
               Constant.SUCCESS,
               " Member created successfully",
               HttpStatus.CREATED.value(),
               memberService.createMember(member)));
   }

   @GetMapping(value = "/getMember/{memberId}",
            consumes = Constant.APPLICATION_JSON,
            produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> getSpecificMember(
            @PathVariable("memberId") String memberId,
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType
   )
   {
      log.info("Request Received to get specific member");
      return ResponseEntity.ok(new Response(true,
               Constant.SUCCESS,
               "Member fetched successfully",
               HttpStatus.OK.value(),
               memberService.getSpecificMember(memberId)));

   }


   @GetMapping(value = "/getAllMembers",
            consumes = Constant.APPLICATION_JSON,
            produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> getSpecificMember(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType
   )
   {
      log.info("Request Received to get all member");
      return ResponseEntity.ok(new Response(true,
               Constant.SUCCESS,
               "All Members fetched successfully",
               HttpStatus.OK.value(),
               memberService.getAllMembers()));

   }

   @GetMapping("/members/{id}/tasks")
   public ResponseEntity<Response> getMemberTasks(@PathVariable("id") String id) {
      // TODO : will return all tasks of specific member
      return ResponseEntity.ok(new Response(true, "Member tasks fetched successfully", null, null, null));
   }

   @GetMapping("/members/{id}/messages")
   public ResponseEntity<Response> getMemberMessages(@PathVariable("id") String id) {
      // TODO : will return all messages of specific member
      return ResponseEntity.ok(new Response(true, "Member messages fetched successfully", null, null, null));
   }

   @DeleteMapping(value = "/deleteMember/{memberId}",
            consumes = Constant.APPLICATION_JSON,
            produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> deleteMember(
            @PathVariable("memberId") String memberId,
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType
   )
   {
      log.info("Request Received to delete member, deleting member...");
      return ResponseEntity.ok(new Response(true,
               Constant.SUCCESS,
               "Member deleted successfully",
               HttpStatus.NO_CONTENT.value(),
               memberService.deleteMember(memberId)));
   }

   @PutMapping(value = "/updateMember/{memberId}",
            consumes = Constant.APPLICATION_JSON,
            produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> updateMember(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @PathVariable("memberId") String memberId,
            @Valid @RequestBody Member member
   )
   {
      log.info("Request Received to update member, updating member...");
      return ResponseEntity.ok(new Response(true,
               Constant.SUCCESS,
               "Member updated successfully",
               HttpStatus.CREATED.value(),
               memberService.updateMember(memberId, member)));
   }

}
