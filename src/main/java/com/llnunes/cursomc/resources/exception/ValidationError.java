package com.llnunes.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
	}

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}	
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}	
}
