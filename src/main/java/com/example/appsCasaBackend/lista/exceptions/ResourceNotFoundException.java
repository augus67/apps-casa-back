package com.example.appsCasaBackend.lista.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1509561149038446799L;
	


	public ResourceNotFoundException() {
		this("No se ha encontrado el recurso.");
	}
	
	public ResourceNotFoundException(String mensaje) {
		this(mensaje, null);
	}
	
	public ResourceNotFoundException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
