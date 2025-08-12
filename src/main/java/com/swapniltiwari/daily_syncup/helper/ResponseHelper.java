package com.swapniltiwari.daily_syncup.helper;

import com.swapniltiwari.daily_syncup.models.Response;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ResponseHelper
{

   /**
    * @param status
    * @param message
    * @param data
    * @param errorData
    * @param displayMessage
    * @param responseCode
    * @return
    */
   public Response buildResponse(Boolean status, String message, Object data,
            Object errorData, String displayMessage, Integer responseCode)
   {
      return new Response(status, message, displayMessage, responseCode, data,
               errorData);
   }

   /**
    * 
    * @param status
    * @param message
    * @param displayMessage
    * @param responseCode
    * @param data
    * @return
    */
   public Response buildResponse(Boolean status, String message,
            String displayMessage, Integer responseCode, Object data)
   {
      return new Response(status, message, displayMessage, responseCode, data);
   }


}
