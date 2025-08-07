package com.amit.restaurantListing.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.amit.restaurantListing.DTO.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request)
	{
		ErrorResponse errorResponse = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage(),
				request.getDescription(false).replace("uri=", "")
				);
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	
	

}
