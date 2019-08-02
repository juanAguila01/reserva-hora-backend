package com.resrvahoras.springboot.backend.apirest.exceptions;

public class ClienteNoExisteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ClienteNoExisteException(String error) {
		super(error);
	}

}
