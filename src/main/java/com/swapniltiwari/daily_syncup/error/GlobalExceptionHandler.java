package com.swapniltiwari.daily_syncup.error;


import com.swapniltiwari.daily_syncup.enums.ErrorMessages;
import com.swapniltiwari.daily_syncup.exceptions.*;
import com.swapniltiwari.daily_syncup.helper.ResponseHelper;
import com.swapniltiwari.daily_syncup.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
   @Autowired
   private ResponseHelper responseHelper;

   @ExceptionHandler({
            FailedDependencyException.class,
            BadRequestException.class,
            ForbiddenException.class,
            NotFoundException.class,
            UnauthorizedException.class,
            InternalServerException.class,
            NotImplementedException.class
   })
   public final ResponseEntity<Response> handleException(Exception ex)
   {
      log.error("Handling exception: {}", ex.getMessage());

      if (ex instanceof FailedDependencyException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.FAILED_DEPENDENCY.getMessage(), ex.getMessage(),
                  (HttpStatus.FAILED_DEPENDENCY.value()), null);
         return new ResponseEntity<>(response, HttpStatus.FAILED_DEPENDENCY);
      }
      else if (ex instanceof BadRequestException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.BAD_REQUEST.getMessage(), ex.getMessage(),
                  (HttpStatus.BAD_REQUEST.value()), null);
         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
      }
      else if (ex instanceof ForbiddenException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.FORBIDDEN.getMessage(), ex.getMessage(),
                  (HttpStatus.FORBIDDEN.value()), null);
         return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
      }
      else if (ex instanceof NotFoundException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.NOT_FOUND.getMessage(), ex.getMessage(),
                  (HttpStatus.NOT_FOUND.value()), null);
         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      }
      else if (ex instanceof UnauthorizedException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.UNAUTHORIZED.getMessage(), ex.getMessage(),
                  (HttpStatus.UNAUTHORIZED.value()), null);
         return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
      }
      else if (ex instanceof InternalServerException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.INTERNAL_SERVER_ERROR.getMessage(), ex.getMessage(),
                  (HttpStatus.INTERNAL_SERVER_ERROR.value()), null);
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      else if (ex instanceof NotImplementedException)
      {
         Response response = responseHelper.buildResponse(false, ErrorMessages.NOT_IMPLEMENTED.getMessage(), ex.getMessage(),
                  (HttpStatus.NOT_IMPLEMENTED.value()), null);
         return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
      }

      Response response = responseHelper.buildResponse(false, ErrorMessages.INTERNAL_SERVER_ERROR.getMessage(), ex.getMessage(),
               (HttpStatus.INTERNAL_SERVER_ERROR.value()), null);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
   }

}
