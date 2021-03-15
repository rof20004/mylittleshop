package br.com.rodolfo.mylittleshop.user.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rodolfo.mylittleshop.user.entities.User;
import br.com.rodolfo.mylittleshop.user.exceptions.UserNotFoundException;
import br.com.rodolfo.mylittleshop.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetUserService {

	private final UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
}
