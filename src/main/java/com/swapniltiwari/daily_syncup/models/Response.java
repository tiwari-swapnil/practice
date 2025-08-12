package com.swapniltiwari.daily_syncup.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@Builder
public class Response
{
   private Boolean status;
   private String message;
   private String displayMessage;
   private Integer responseCode;
   private Object data;
   private Object errorData;

   public Response(Boolean status, String message, String displayMessage,
            Integer responseCode, Object data)
   {
      super();
      this.status = status;
      this.message = message;
      this.displayMessage = displayMessage;
      this.responseCode = responseCode;
      this.data = data;
   }

   public Response(Boolean status, String message, String displayMessage,
            Integer responseCode, Object data, Object errorData)
   {
      super();
      this.status = status;
      this.message = message;
      this.responseCode = responseCode;
      this.displayMessage = displayMessage;
      this.data = data;
      this.errorData = errorData;
   }


}
