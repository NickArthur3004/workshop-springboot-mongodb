package com.nicolasarthur.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasarthur.workshopmongo.domain.User;
import com.nicolasarthur.workshopmongo.dto.UserDTO;
import com.nicolasarthur.workshopmongo.repository.UserRepository;
import com.nicolasarthur.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User FromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}

}
