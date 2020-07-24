package com.llnunes.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Long timestamp;
	@Getter @Setter
	private Integer status;
	@Getter @Setter
	private String error;
	@Getter @Setter
	private String message;
	@Getter @Setter
	private String path;
	
	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}