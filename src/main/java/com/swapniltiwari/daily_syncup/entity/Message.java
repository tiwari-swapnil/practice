package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "message_id")
   private Long messageId;

   @Column(name = "content")
   private String content;

   @Column(name = "sent_at")
   private LocalDateTime sentAt;

   @Column(name = "is_deleted")
   private Boolean isDeleted = false;

   @ManyToOne
   @JoinColumn(name = "from_member_id")
   private Member fromMember;

   @ManyToOne
   @JoinColumn(name = "to_member_id")
   private Member toMember;

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;
}
