package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "members")
@Data
public class Member
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long memberId;

   private String userName;

   private String fullName;

   private String role;

   @ManyToOne
   @JoinColumn(name = "team_id")
   private Team team;
}
