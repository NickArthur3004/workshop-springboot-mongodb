package com.nicolasarthur.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nicolasarthur.workshopmongo.domain.Post;
import com.nicolasarthur.workshopmongo.domain.User;
import com.nicolasarthur.workshopmongo.dto.AuthorDTO;
import com.nicolasarthur.workshopmongo.repository.PostRepository;
import com.nicolasarthur.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
		Post pos1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viajem", "vou para são paulo abraços", new AuthorDTO( maria));
		Post pos2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO( maria));
		
		
		postRepository.saveAll(Arrays.asList(pos1, pos2));
		
	}

}
