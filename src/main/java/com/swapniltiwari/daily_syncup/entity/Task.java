package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
@Data
public class Task
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "task_id")
   private Long taskId;

   @Column(name = "title")
   private String title;

   @Column(length = 1000, name = "description")
   private String description;

   @Column(name = "is_deleted")
   private Boolean isDeleted = false;

   @Column(name = "is_completed")
   private boolean isCompleted = false;

   @ManyToOne
   @JoinColumn(name = "assigned_to")
   private Member assignedTo;

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;
}
