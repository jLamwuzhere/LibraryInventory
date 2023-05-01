package com.joelambert.libraryinventory.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.joelambert.libraryinventory.models.LoginUser;
import com.joelambert.libraryinventory.models.User;
import com.joelambert.libraryinventory.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	// REGISTER METHOD
	public User register(User newUser, BindingResult results) {
		// CHECK TO SEEE IF EMAIL IS ALREADY TAKEN
				if(this.checkEmail(newUser.getEmail())) {
					results.rejectValue("email", "Duplicate", "Email already exists");
				}

		// CHECK TO SEE PASSWORD AND CONFIRM PASSWORD DOES NOT MATCH
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			results.rejectValue("confirm","Confirm","Password and Confirm Password MUST MATCH");
		}
		if(results.hasErrors()) {
			return null;
		}
		
		// HASH AND SET PASSWORD, SAVE USER TO DB
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	// LOGIN METHOD
	public User login(LoginUser newLoginObject, BindingResult results) {
		// FIND THE USER IN THE DB
		if(!this.checkEmail(newLoginObject.getEmail())) {
			results.rejectValue("email", "Non-existent", "INVALID CREDENTIALS");
		}
		if(results.hasErrors()) {
		return null;
		}
		
		// CHECK TO SEE IF PASSWORD MATCHES
		User user = userRepo.findByEmail(newLoginObject.getEmail()).orElse(null);
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			results.rejectValue("password", "Matches", "Invalied Password!");
		}
		if(results.hasErrors()) {
			return null;
		}
			return user;
	}
		
	public boolean checkEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		if(user.isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}
	public User getOneUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}


}
