package com.swapniltiwari.daily_syncup.repositories;

import com.swapniltiwari.daily_syncup.entity.SyncUpEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyncUpEntryRepository extends JpaRepository<SyncUpEntry, Long>
{
}
