package com.pruebaCapitol.prices.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PricesExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {InvalidDateException.class})
	public ResponseEntity<ErrorResponse> handleInvalidDateException(RuntimeException e, WebRequest request){
		ErrorResponse response = new ErrorResponse();
		response.setMessage("Formato de fecha no valido. Formato correcto -> yyyy-MM-dd-hh.mm.ss");
		response.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {InvalidNumber.class})
	public ResponseEntity<ErrorResponse> handleInvalidNumberException(RuntimeException e, WebRequest request){
		ErrorResponse response = new ErrorResponse();
		response.setMessage("Formato de numero incorrecto.");
		response.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
