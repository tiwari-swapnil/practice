package com.swapniltiwari.daily_syncup.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "configs")
public class Configs
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "config_id")
   private Integer configId;

   @Column(name = "config_key", nullable = false, length = 100)
   private String configKey;

   @Lob
   @Column(name = "config_val", length = 65535)
   private String configVal;

   @Column(name = "val_type", length = 25, nullable = false)
   private String valType;

   @Lob
   @Column(name = "description", length = 500, nullable = false)
   private String description;

   @Column(name = "is_deleted")
   private Boolean isDeleted = false;

   @CreationTimestamp
   @Column(name = "created_on", nullable = false, updatable = false)
   private Timestamp createdOn;

   @UpdateTimestamp
   @Column(name = "modified_on")
   private Timestamp modifiedOn;
}
