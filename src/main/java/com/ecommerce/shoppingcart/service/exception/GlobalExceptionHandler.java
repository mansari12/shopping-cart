/**
 * 
 */
package com.ecommerce.shoppingcart.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.shoppingcart.error.ErrorResponse;

/**
 * 
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDetails("custom error occured");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDetails("General error occured");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
