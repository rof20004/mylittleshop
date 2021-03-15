package br.com.rodolfo.mylittleshop.user.exceptions;

public class UserPayloadException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User information was not found in request body";
	
	public UserPayloadException() {
		super(MESSAGE);
	}

}
