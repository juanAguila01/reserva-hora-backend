package com.resrvahoras.springboot.backend.apirest.exceptions;

public class ReservaFechaIncorrectaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 121L;
	
	public ReservaFechaIncorrectaException(String error) {
		super(error);
	}

}
