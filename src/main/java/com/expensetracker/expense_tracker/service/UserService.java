package com.expensetracker.expense_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id){
    	return userRepository.findById(id)
    			.orElseThrow(()->new RuntimeException("User not found with id: "+id));
    }
    
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }
        return userRepository.save(user);
    }

	
	public User updateUser(Long id, User updatedUser) {
	    User user = userRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

	    user.setName(updatedUser.getName());
	    user.setEmail(updatedUser.getEmail());
	    user.setPassword(updatedUser.getPassword());

	    return userRepository.save(user);
	}

	public void deleteUser(Long id) {
	    if (!userRepository.existsById(id)) {
	        throw new RuntimeException("User not found with id: " + id);
	    }
	    userRepository.deleteById(id);
	}

}
