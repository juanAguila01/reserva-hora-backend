package com.resrvahoras.springboot.backend.apirest.exceptions;

public class ClienteErrorEmailException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 24L;

	public ClienteErrorEmailException(String error) {
		super(error);
	}

}
