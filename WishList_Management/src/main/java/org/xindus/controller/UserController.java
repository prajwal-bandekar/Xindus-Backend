package org.xindus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u){
		return service.saveUser(u);
	}
	
	@PutMapping("/user/{uID}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u, @PathVariable int uID){
		return service.updateUser(u,uID);
	}
	
	@GetMapping("/user/{uID}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<ResponseStructure<User>> findByID(@PathVariable int uID){
		return service.findById(uID);
	}

	@DeleteMapping("/user/{uID}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int uID){
		return service.deleteUser(uID);
	}
}
