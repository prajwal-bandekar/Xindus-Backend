package org.xindus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xindus.dao.UserDao;
import org.xindus.entity.ResponseStructure;
import org.xindus.entity.User;
import org.xindus.exception.IdNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//POST
	public ResponseEntity<ResponseStructure<User>> saveUser(User u){
		ResponseStructure<User> structure = new ResponseStructure<>();
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		structure.setData(uDao.saveUser(u));
		structure.setMessage("User Account Created Succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}
	
	//PUT 
	public ResponseEntity<ResponseStructure<User>> updateUser(User u, int uID)
	{
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = uDao.findUserById(uID);
		if(recUser.isPresent()) 
		{
			u.setUID(uID);
			u.setPassword(passwordEncoder.encode(u.getPassword()));
			structure.setData(uDao.updateUser(u));
			structure.setMessage("Product Details Updated Succesfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
		}
		
	throw new IdNotFoundException();
	
	}
	
	//GET
	public ResponseEntity<ResponseStructure<User>> findById(int uID){
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = uDao.findUserById(uID);
		
		if(recUser.isPresent()) {
			structure.setMessage("User Found Successfully");
			structure.setData(recUser.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	//DELETE - /delete/{User_id}
	public ResponseEntity<ResponseStructure<String>> deleteUser(int uID){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> recUser = uDao.findUserById(uID);
		if(recUser.isPresent()) {
			uDao.deleteUser(uID);
			structure.setMessage("Task Executed");
			structure.setData("User Deleted Succesfully");		
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	} 
}
