package com.mantunes.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mantunes.cursomc.services.exception.ObjectNotfoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotfoundException.class)
	public	ResponseEntity<StandardError> objectNotFound(ObjectNotfoundException e,
			HttpServletRequest request) {
			StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
													System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}