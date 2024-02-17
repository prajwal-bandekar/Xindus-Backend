package org.xindus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xindus.entity.ResponseStructure;
import org.xindus.entity.User;
import org.xindus.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/User")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u){
		return service.saveUser(u);
	}
	
	@PutMapping("/User")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u){
		return service.updateUser(u);
	}
	
	@GetMapping("/User/{uID}")
	public ResponseEntity<ResponseStructure<User>> findByID(@PathVariable int uID){
		return service.findById(uID);
	}

	@DeleteMapping("/User/{uID}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int uID){
		return service.deleteUser(uID);
	}
}
