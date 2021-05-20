package com.example.infy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.infy.dao.UserRepository;
import com.example.infy.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	public User getUserById(int id) {

		return userRepository.findById(id).orElse(null);

	}

	public List<User> getUsers() {
		return userRepository.findAll();
		
	}
	public User updateUser(User user) {
		User oldUser=null;
		Optional<User>optionalUser=userRepository.findById(user.getId());
		if(optionalUser.isPresent()) {
			oldUser=optionalUser.get();
			oldUser.setName(user.getName());
			oldUser.setAdress(user.getAdress());
			userRepository.save(oldUser);
		}else {
			return new User();
		}
		return oldUser;
	}
	
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "user got deleted";
	}
}
