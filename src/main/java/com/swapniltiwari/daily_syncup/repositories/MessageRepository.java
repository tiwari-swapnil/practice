package com.swapniltiwari.daily_syncup.repositories;

import com.swapniltiwari.daily_syncup.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>
{
}
