package com.resrvahoras.springboot.backend.apirest.exceptions;

public class ReservaHoraIncorrectaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7654L;
	
	public ReservaHoraIncorrectaException(String error) {
		super(error);
	}

}
