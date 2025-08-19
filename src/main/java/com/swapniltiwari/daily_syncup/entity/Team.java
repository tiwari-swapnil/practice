package com.swapniltiwari.daily_syncup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "team_id")
   private Long teamId;

   @Column(name = "team_name", unique = true, nullable = false)
   @NotBlank(message = "team name is required")
   private String teamName;

   @Column(name = "is_deleted")
   private Boolean isDeleted;

   @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
   private Set<Member> members = new HashSet<>();

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;

}
