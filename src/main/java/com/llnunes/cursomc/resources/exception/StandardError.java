package com.llnunes.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Integer status;
	
	@Getter @Setter
	private String msg;
	
	@Getter @Setter
	private Long timeStamp;

	public StandardError() {
		super();
	}

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
}