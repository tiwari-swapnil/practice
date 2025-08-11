package com.swapniltiwari.daily_syncup.repositories;

import com.swapniltiwari.daily_syncup.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>
{
}
