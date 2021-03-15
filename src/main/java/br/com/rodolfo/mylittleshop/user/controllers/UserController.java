package br.com.rodolfo.mylittleshop.user.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodolfo.mylittleshop.user.dtos.CreateUserDto;
import br.com.rodolfo.mylittleshop.user.dtos.UpdateUserDto;
import br.com.rodolfo.mylittleshop.user.entities.User;
import br.com.rodolfo.mylittleshop.user.services.CreateUserService;
import br.com.rodolfo.mylittleshop.user.services.GetUserService;
import br.com.rodolfo.mylittleshop.user.services.UpdateUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final CreateUserService createUserService;
	private final UpdateUserService updateUserService;
	private final GetUserService getUserService;
	
	@PostMapping
	public User create(@RequestBody CreateUserDto dto) {
		var user = User.builder()
				.name(dto.getName())
				.registrationNumber(dto.getRegistrationNumber())
				.phone(dto.getPhone())
				.email(dto.getEmail())
				.password(dto.getPassword())
				.build();
		
		return createUserService.create(user);
	}
	
	@PutMapping("/{id}")
	public User update(@PathVariable("id") Long id, @RequestBody UpdateUserDto dto) {
		var user = getUserService.findById(id);
		user.setPhone(dto.getPhone());
		user.setEmail(dto.getEmail());
		return updateUserService.update(user);
	}
	
	@GetMapping
	public List<User> list() {
		return getUserService.findAll();
	}
	
}
