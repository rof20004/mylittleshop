package br.com.rodolfo.mylittleshop.user.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.rodolfo.mylittleshop.user.entities.User;
import br.com.rodolfo.mylittleshop.user.exceptions.UserPhoneRequiredException;
import br.com.rodolfo.mylittleshop.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

	private final UserRepository repository;
	
	public User update(User user) {
		validate(user);
		return repository.save(user);
	}
	
	private void validate(User user) {
		if (!StringUtils.hasText(user.getPhone())) {
			throw new UserPhoneRequiredException();
		}
	}
	
}
