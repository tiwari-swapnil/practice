package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController
{
   @PostMapping("/create-message")
   public ResponseEntity<Response> createMessage() {
      // TODO : will create message
      return ResponseEntity.ok(new Response(true, "Message created successfully", null, null, null));
   }

   @PostMapping("/send-message/{id}")
   public ResponseEntity<Response> sendMessage(@PathVariable("id") String id) {
      // TODO : will send message to specific member
      return ResponseEntity.ok(new Response(true, "Message sent successfully", null, null, null));
   }

   @DeleteMapping("/delete-message/{memberId}/{id}")
   public ResponseEntity<Response> deleteMessage(@PathVariable("memberId") String memberId, @PathVariable("id") String id) {
      // TODO : will delete message
      return ResponseEntity.ok(new Response(true, "Message deleted successfully", null, null, null));
   }

   @PutMapping("/update-message/{id}")
   public ResponseEntity<Response> updateMessage(@PathVariable("id") String id) {
      // TODO : will update message
      return ResponseEntity.ok(new Response(true, "Message updated successfully", null, null, null));
   }

}
