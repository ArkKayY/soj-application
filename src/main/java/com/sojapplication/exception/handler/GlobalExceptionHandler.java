package com.sojapplication.exception.handler;

import com.sojapplication.exception.SojException;
import com.sojapplication.model.ErrorDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SojException.class)
	public ResponseEntity<ErrorDetails> sojExceptionHandler(final SojException sojException,
															final WebRequest webRequest) {
		final ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),
														   sojException.getMessage(),
														   webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
