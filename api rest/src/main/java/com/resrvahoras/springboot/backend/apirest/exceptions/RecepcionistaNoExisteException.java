package com.resrvahoras.springboot.backend.apirest.exceptions;

public class RecepcionistaNoExisteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 123232L;
	
	public RecepcionistaNoExisteException(String msj){
		super(msj);
	}
	
	

}
