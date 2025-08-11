package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String content;

   private LocalDateTime sentAt;

   @ManyToOne
   @JoinColumn(name = "from_member_id")
   private Member fromMember;

   @ManyToOne
   @JoinColumn(name = "to_member_id")
   private Member toMember;
}
