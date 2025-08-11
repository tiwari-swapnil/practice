package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController
{
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

   @PostMapping("/create-member")
   public ResponseEntity<Response> createMember() {
      // TODO : will create member
      return ResponseEntity.ok(new Response(true, "Member created successfully", null, null, null));
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
