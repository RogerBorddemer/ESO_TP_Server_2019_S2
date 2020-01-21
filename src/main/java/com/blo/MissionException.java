package com.blo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN)
public class MissionException extends RuntimeException {

	public MissionException(String message) {
		super(message);
	}
}
