package com.llnunes.cursomc.services.exception;

public class ObjectNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException() {
		super();
	}
	
	public ObjectNotFoundException(Throwable t) {
		super(t);
	}
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable problem) {
		super(msg, problem);
	}	
}
