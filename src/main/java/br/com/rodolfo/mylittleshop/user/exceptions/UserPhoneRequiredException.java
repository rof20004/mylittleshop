package br.com.rodolfo.mylittleshop.user.exceptions;

public class UserPhoneRequiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User phone is required";
	
	public UserPhoneRequiredException() {
		super(MESSAGE);
	}

}
