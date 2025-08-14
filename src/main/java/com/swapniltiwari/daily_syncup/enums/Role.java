package com.swapniltiwari.daily_syncup.enums;

public enum Role {
   TEAM_LEAD("TEAM_LEAD"),
   DEVELOPER("DEVELOPER"),
   QA("QA"),
   SCRUM_MASTER("SCRUM_MASTER"),
   DESIGNER("DESIGNER"),
   INTERN("INTERN");

   private final String message;

   Role(String message) {
      this.message = message;
   }

   public String getMessage() {
      return message;
   }
}
