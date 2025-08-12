package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.repositories.MemberRepository;
import com.swapniltiwari.daily_syncup.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService
{

   @Autowired
   private MemberRepository memberRepository;

   @Override
   public Object createMember(Member member)
   {
      try{
         //Optional.ofNullable(member).orElseThrow(() -> new BadRequestException("Required data is missing"));
         if(Objects.isNull(member.getIsDeleted())) member.setIsDeleted(false);
         return memberRepository.save(member);
      }
      catch (Exception e){
         log.error("Exception occurred while creating or adding member");
         throw e;
      }
   }
}
