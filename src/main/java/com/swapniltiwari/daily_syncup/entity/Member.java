package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "members")
@Data
public class Member
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "member_id")
   private Long memberId;

   @NotBlank(message = "userName is required")
   @Column(name = "user_name", unique = true)
   private String userName;

   @NotBlank(message = "fullName is required")
   @Column(name = "full_name")
   private String fullName;

   @NotBlank(message = "role is required")
   @Column(name = "role")
   private String role;

   @Column(name = "is_deleted")
   private Boolean isDeleted;

   @ManyToOne
   @JoinColumn(name = "team_id")
   private Team team;

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;
}
