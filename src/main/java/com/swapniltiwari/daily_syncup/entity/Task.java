package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String title;

   @Column(length = 1000)
   private String description;

   private boolean completed = false;

   @ManyToOne
   @JoinColumn(name = "assigned_to")
   private Member assignedTo;
}
