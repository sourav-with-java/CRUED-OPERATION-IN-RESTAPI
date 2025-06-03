package com.Tarining.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.service.annotation.PutExchange;

import com.Tarining.OnlineTraining.ResourceNotFoundException;
import com.Tarining.utills.MyResponseHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private BindException ex;
	private FieldError error;

	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> exceptionhandle()
	{
		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Id Not Found", getClass());
	}
	
	@ResponseStatus(value =HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<Object> handleArgumentExp(MethodArgumentNotValidException argument)
	{
		Map<String, String> errorMap=new HashMap<String, String>();
		
		ex.
		getBindingResult().
		getAllErrors()
		.forEach(error)->
		{
			
		String fieldName=((FieldError)error).getField(); 
		String erroMessage=((FieldError)error).getDefaultMessage();
				errorMap.put(fieldName,erroMessage);
		};
		
		
		
		return MyResponseHandler.generateResponse(HttpStatus.BAD_GATEWAY, false, "Server Side Error", errorMap);
	}

}
