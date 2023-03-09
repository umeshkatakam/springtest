package com.example.Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class ControllerException {
	
 
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ErrorMessage  methodtFounexecption(MethodArgumentNotValidException ex,WebRequest re) {
		
		List<String> errorNames=ex.getBindingResult().getFieldErrors().stream().map(x-> x.getDefaultMessage())
				.collect(Collectors.toList());
		ErrorMessage error=new ErrorMessage(
				HttpStatus.NOT_FOUND.value(), new Date(), errorNames,re.getDescription(false));
				
		return error;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ErrorMessage  resourceNotFounexecption(ResourceNotFoundException ex,WebRequest re) {
		List<String> errorName=Arrays.asList(ex.getMessage());
		ErrorMessage error=new ErrorMessage(
				HttpStatus.NOT_FOUND.value(), new Date(), errorName,re.getDescription(false));
				
		return error;
	}

}
