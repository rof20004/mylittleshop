package br.com.rodolfo.mylittleshop.user.exceptions;

public class UserEmailRequiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User e-mail is required";
	
	public UserEmailRequiredException() {
		super(MESSAGE);
	}

}
