package org.xindus.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xindus.entity.User;
import org.xindus.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository uRepo;
	
	public User saveUser( User u) {
		return uRepo.save(u);
	}
	
	public User updateUser( User u) {
		return uRepo.save(u);
	}
	
	public Optional<User> findUserById(int UserID) {
		return uRepo.findById(UserID);
	}
	
	public void deleteUser(int UserID) {
		uRepo.deleteById(UserID);
	}
}
