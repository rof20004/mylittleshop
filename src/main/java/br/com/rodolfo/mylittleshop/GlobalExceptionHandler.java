package br.com.rodolfo.mylittleshop;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rodolfo.mylittleshop.user.exceptions.UserEmailRequiredException;
import br.com.rodolfo.mylittleshop.user.exceptions.UserNameRequiredException;
import br.com.rodolfo.mylittleshop.user.exceptions.UserNotFoundException;
import br.com.rodolfo.mylittleshop.user.exceptions.UserPayloadException;
import br.com.rodolfo.mylittleshop.user.exceptions.UserPhoneRequiredException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private ApplicationError buildApplicationError(RuntimeException e) {
		ApplicationError error = ApplicationError.builder()
				.timestamp(LocalDateTime.now())
				.message(e.getMessage())
				.build();
		return error;
	}
	
	@ExceptionHandler(value = UserPayloadException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public ApplicationError handle(UserPayloadException e) {
		return buildApplicationError(e);
	}

	@ExceptionHandler(value = UserNameRequiredException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApplicationError handle(UserNameRequiredException e) {
		return buildApplicationError(e);
	}
	
	@ExceptionHandler(value = UserPhoneRequiredException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApplicationError handle(UserPhoneRequiredException e) {
		return buildApplicationError(e);
	}
	
	@ExceptionHandler(value = UserEmailRequiredException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApplicationError handle(UserEmailRequiredException e) {
		return buildApplicationError(e);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApplicationError handle(UserNotFoundException e) {
		return buildApplicationError(e);
	}
	
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ApplicationError {
	
	private LocalDateTime timestamp;
	private String message;
	
}