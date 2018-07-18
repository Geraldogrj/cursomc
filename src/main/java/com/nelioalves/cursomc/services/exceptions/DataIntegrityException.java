package com.nelioalves.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException (String msg) {
		super(msg);
		
	}
	
	//Sobrecarga para quando receber uma exceção anterior
	public DataIntegrityException (String msg, Throwable causa) {
		super(msg, causa);
	}

}
