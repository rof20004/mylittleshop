package br.com.rodolfo.mylittleshop.user.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.rodolfo.mylittleshop.user.entities.User;
import br.com.rodolfo.mylittleshop.user.exceptions.UserNameRequiredException;
import br.com.rodolfo.mylittleshop.user.exceptions.UserPayloadException;
import br.com.rodolfo.mylittleshop.user.exceptions.UserPhoneRequiredException;
import br.com.rodolfo.mylittleshop.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserService {

	private final UserRepository repository;
	
	public User create(User user) {
		validate(user);
		return repository.save(user);
	}
	
	private void validate(User user) {
		if (user == null) {
			throw new UserPayloadException();
		}
		
		if (!StringUtils.hasText(user.getName())) {
			throw new UserNameRequiredException();
		}
		
		if (!StringUtils.hasText(user.getPhone())) {
			throw new UserPhoneRequiredException();
		}
	}
	
}
