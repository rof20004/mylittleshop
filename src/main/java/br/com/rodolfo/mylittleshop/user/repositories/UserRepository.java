package br.com.rodolfo.mylittleshop.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.mylittleshop.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
