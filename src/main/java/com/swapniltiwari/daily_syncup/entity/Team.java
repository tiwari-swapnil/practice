package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "team")
@Data
public class Team
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long teamId;

   private String teamName;

   @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
   private Set<Member> members;
}
