package com.th.utility;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.th.exception.ThBankException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	Environment environment;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.ACCEPTED.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ThBankException.class)
	public ResponseEntity<ErrorInfo> thBankExceptionHandler(ThBankException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
}
