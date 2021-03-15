package br.com.rodolfo.mylittleshop.user.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User #%d not found";
	
	public UserNotFoundException(Long id) {
		super(String.format(MESSAGE, id));
	}

}
