package com.nicolasarthur.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasarthur.workshopmongo.domain.Post;
import com.nicolasarthur.workshopmongo.domain.User;
import com.nicolasarthur.workshopmongo.dto.UserDTO;
import com.nicolasarthur.workshopmongo.repository.PostRepository;
import com.nicolasarthur.workshopmongo.repository.UserRepository;
import com.nicolasarthur.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
