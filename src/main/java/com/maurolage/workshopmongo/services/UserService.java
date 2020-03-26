package com.maurolage.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurolage.workshopmongo.domain.User;
import com.maurolage.workshopmongo.repository.UserRepository;
import com.maurolage.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		// Optional<User> user = repo.findById(id);
		//User user = repo.findOne(id);
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
//		 if (user == null) {
//			 throw new ObjectNotFoundException("Objeto não encontrado");
//		 }
//		 return user;
	}
}
