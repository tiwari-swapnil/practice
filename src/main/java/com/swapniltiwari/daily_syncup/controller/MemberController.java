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

   @PostMapping(value = "/create-member", consumes = Constant.APPLICATION_JSON, produces = Constant.APPLICATION_JSON)
   public ResponseEntity<Response> createMember(
            @RequestHeader(HttpHeaders.ACCEPT) String accept,
            @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
            @Valid @RequestBody Member member
   ) {
      log.info("Request Received to create member, creating member...");
      return ResponseEntity.ok(new Response(true, "SUCCESS"," Member created successfully",
               HttpStatus.CREATED.value(), memberService.createMember(member)));
   }

   @GetMapping("/get-member/{id}")
   public ResponseEntity<Response> getMember(@PathVariable("id") String id) {
      // TODO : will return specific member
      return ResponseEntity.ok(new Response(true, "Member fetched successfully", null, null, null));
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

   @DeleteMapping("/delete-member")
   public ResponseEntity<Response> deleteMember() {
      // TODO : will delete member
      return ResponseEntity.ok(new Response(true, "Member deleted successfully", null, null, null));
   }

   @PutMapping("/update-member")
   public ResponseEntity<Response> updateMember() {
      // TODO : will update member
      return ResponseEntity.ok(new Response(true, "Member updated successfully", null, null, null));
   }

}
