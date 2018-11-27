package com.mantunes.cursomc.services.exception;

import javassist.tools.rmi.ObjectNotFoundException;

public class ObjectNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotfoundException(String msg) {
		super(msg);
	}
	public ObjectNotfoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}	