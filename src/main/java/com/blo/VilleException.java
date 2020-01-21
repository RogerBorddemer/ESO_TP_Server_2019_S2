package com.blo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN)
public class VilleException extends RuntimeException {

	public VilleException(String message) {
		super(message);
	}
}
