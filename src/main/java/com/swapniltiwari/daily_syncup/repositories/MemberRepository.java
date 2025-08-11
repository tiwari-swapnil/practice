package com.swapniltiwari.daily_syncup.repositories;

import com.swapniltiwari.daily_syncup.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>
{
}
