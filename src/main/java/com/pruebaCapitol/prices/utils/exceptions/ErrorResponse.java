package com.pruebaCapitol.prices.utils.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {

	private HttpStatus status;
	private String message;
	List<String> errors;
	

	
}
