package com.swapniltiwari.daily_syncup.exceptions;

public class BadRequestException extends RuntimeException
{
   public BadRequestException(String message)
   {
      super(message);
   }
}
