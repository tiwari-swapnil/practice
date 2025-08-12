package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "team")
@Data
public class Team
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "team_id")
   private Long teamId;

   @Column(name = "team_name")
   private String teamName;

   @Column(name = "is_deleted")
   private Boolean isDeleted;

   @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
   private Set<Member> members;

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;

}
