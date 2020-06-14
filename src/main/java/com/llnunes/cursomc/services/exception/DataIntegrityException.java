package com.llnunes.cursomc.services.exception;

public class DataIntegrityException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException() {
		super();
	}
	
	public DataIntegrityException(Throwable t) {
		super(t);
	}
	
	public DataIntegrityException(String msg) { //
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable problem) { //
		super(msg, problem);
	}	
}
