package com.resrvahoras.springboot.backend.apirest.exceptions;

public class ReservaErrorCantidadMaximaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 21347L;
	
	public ReservaErrorCantidadMaximaException(String error) {
		super(error);
	}

}
