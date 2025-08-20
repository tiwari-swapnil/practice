package com.swapniltiwari.daily_syncup.service.Impl;

import com.swapniltiwari.daily_syncup.entity.Member;
import com.swapniltiwari.daily_syncup.exceptions.BadRequestException;
import com.swapniltiwari.daily_syncup.helper.HelperMethods;
import com.swapniltiwari.daily_syncup.repositories.MemberRepository;
import com.swapniltiwari.daily_syncup.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

   @Autowired
   private HelperMethods helperMethods;

   @Override
   public Object createMember(Member member)
   {
      try
      {
         Optional.ofNullable(member)
                  .orElseThrow(() -> new BadRequestException("Required member data is missing"));

         if (Objects.isNull(member.getIsDeleted())) member.setIsDeleted(false);
         member.setRole(helperMethods.getRoleValue(member.getRole()));
         return memberRepository.save(member);
      }
      catch (Exception e)
      {
         log.error("Exception occurred while creating or adding member");
         throw e;
      }
   }

   @Override
   public Object getSpecificMember(String memberId)
   {
      try
      {
         return memberRepository.findByMemberId(Long.parseLong(memberId)).orElseThrow(
                  () -> new BadRequestException("Member not found with id: " + memberId));
      }
      catch (Exception e)
      {
         log.error("Exception occurred while getting specific member");
         throw e;
      }
   }

   @Override
   public Object getAllMembers()
   {
      try{
            return memberRepository.findAllByIsDeletedFalse();
      }
      catch (Exception e) {
         log.error("Exception occurred while fetching all the members : ", e);
         throw e;
      }
   }

   @Override
   public Object deleteMember(String memberId)
   {
      try{
         Member member = memberRepository.findByMemberIdAndIsDeletedFalse(Long.parseLong(memberId))
                  .orElseThrow(
                           () -> new BadRequestException("Member not found with id: " + memberId));

         member.setIsDeleted(true);
         return memberRepository.save(member);
      }catch (Exception e) {
         log.error("Exception occurred while deleting member : ", e);
         throw e;
      }
   }

   @Override
   public Object updateMember(String memberId, Member member)
   {
      try{
         Member mem = memberRepository.findByMemberIdAndIsDeletedFalse(Long.parseLong(memberId))
                  .orElseThrow(() -> new BadRequestException(
                           "Member not found with id: " + memberId));

         if (StringUtils.isNotEmpty(member.getUserName())) {
            mem.setUserName(member.getUserName());
         }
         if ( StringUtils.isNotEmpty(  member.getFullName())) {
            mem.setFullName(member.getFullName());
         }
         if (StringUtils.isNotEmpty(member.getRole())) {
            mem.setRole(helperMethods.getRoleValue(member.getRole()));
         }

         return memberRepository.save(mem);

      }catch (Exception e) {
         log.error("Exception occurred while updating member : ", e);
         throw e;
      }
   }
}
