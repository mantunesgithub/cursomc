package com.mantunes.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mantunes.cursomc.services.exception.DataIntegrityException;
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
	
	@ExceptionHandler(DataIntegrityException.class)
	public	ResponseEntity<StandardError> DataIntegrity(DataIntegrityException e,
			HttpServletRequest request) {
			StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
													System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);																																													
	}
}