package com.swapniltiwari.daily_syncup.repositories;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long>
{
    boolean existsByTeamNameIgnoreCase(String teamName);

    List<Team> findByIsDeletedFalse();

    Optional<Team> findByIdAndIsDeletedFalse(Long id);

    List<Member> findByTeamIdAndIsDeletedFalse(Long teamId);



}
