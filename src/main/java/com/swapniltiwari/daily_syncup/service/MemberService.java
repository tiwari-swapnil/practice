package com.swapniltiwari.daily_syncup.service;

import com.swapniltiwari.daily_syncup.entity.Member;
import jakarta.validation.Valid;

public interface MemberService
{
   Object createMember(Member member);

   Object getSpecificMember(String memberId);

   Object getAllMembers();

   Object deleteMember(String memberId);

   Object updateMember(String memberId, @Valid Member member);
}
