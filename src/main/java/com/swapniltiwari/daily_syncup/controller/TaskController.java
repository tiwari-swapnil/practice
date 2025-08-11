package com.swapniltiwari.daily_syncup.controller;

import com.swapniltiwari.daily_syncup.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
   @PostMapping("/create-task")
   public ResponseEntity<Response> createTask() {
      // TODO : will create task
      return ResponseEntity.ok(new Response(true, "Task created successfully", null, null, null));
   }

   @PostMapping("/update-task")
   public ResponseEntity<Response> updateTask() {
      // TODO : will update task
      return ResponseEntity.ok(new Response(true, "Task updated successfully", null, null, null));
   }

   @DeleteMapping("/delete-task")
   public ResponseEntity<Response> deleteTask() {
      // TODO : will delete task
      return ResponseEntity.ok(new Response(true, "Task deleted successfully", null, null, null));
   }

   @PostMapping("/assign-task/{id}")
   public ResponseEntity<Response> assignTask(@PathVariable("id") String id) {
      // TODO : will assign task to specific member
      return ResponseEntity.ok(new Response(true, "Task assigned successfully", null, null, null));
   }
}
