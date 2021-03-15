package br.com.rodolfo.mylittleshop.user.exceptions;

public class UserNameRequiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User name is required";
	
	public UserNameRequiredException() {
		super(MESSAGE);
	}
	
}
