package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "sync_up_entries")
public class SyncUpEntry
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "sync_up_entry_id")
   private Long syncUpEntryId;

   @Column(name = "date")
   private LocalDate date;

   @Column(length = 1000, name = "previous_day_work")
   private String previousDayWork;

   @Column(length = 1000, name = "today_plan")
   private String todayPlan;

   @Column(name = "is_deleted")
   private Boolean isDeleted;

   @ManyToOne
   @JoinColumn(name = "member_id")
   private Member member;

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;
}
