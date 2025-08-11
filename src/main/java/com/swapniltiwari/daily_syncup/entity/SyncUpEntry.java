package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sync_up_entries")
public class SyncUpEntry
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDate date;

   @Column(length = 1000)
   private String previousDayWork;

   @Column(length = 1000)
   private String todayPlan;

   @ManyToOne
   @JoinColumn(name = "member_id")
   private Member member;
}
