package com.llnunes.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String fieldName;
	
	@Getter @Setter
	private String message;
	
	public FieldMessage() {
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}	
}
