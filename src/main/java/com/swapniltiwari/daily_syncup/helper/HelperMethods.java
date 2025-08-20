package com.swapniltiwari.daily_syncup.helper;

import com.swapniltiwari.daily_syncup.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class HelperMethods
{

   public String getRoleValue(String role){
      switch(role.toLowerCase()){
         case "teamlead" -> role = Role.TEAM_LEAD.getMessage();
         case "developer" -> role = Role.DEVELOPER.getMessage();
         case "intern" -> role = Role.INTERN.getMessage();
         case "qa" -> role = Role.QA.getMessage();
         case "scrummaster" -> role = Role.SCRUM_MASTER.getMessage();
         case "designer" -> role = Role.DESIGNER.getMessage();
         default -> role = "NA";
      }
      return role;
   }
}
