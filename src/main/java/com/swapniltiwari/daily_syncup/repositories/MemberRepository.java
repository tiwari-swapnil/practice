package com.swapniltiwari.daily_syncup.repositories;

import com.swapniltiwari.daily_syncup.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>
{
    List<Member> findByTeam_TeamIdAndRoleAndIsDeletedFalse(Long teamId, String role);

    Optional<Member> findByMemberId(Long memberId);

    List<Member> findAllByIsDeletedFalse();

    Optional<Member> findByMemberIdAndIsDeletedFalse(Long memberId);


}
