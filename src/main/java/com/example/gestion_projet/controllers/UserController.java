package com.example.gestion_projet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion_projet.models.User;

import com.example.gestion_projet.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("")
	public List<User>getAllUser(){
		return this.userService.getAllUser();
	}
	@PostMapping
	public User addUser(@RequestBody User a) {
		return this.userService.addUser(a);
	}
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return this.userService.getById(id);
	}
	@PutMapping("/{id}")
	public User update(@PathVariable Long id,@RequestBody User a) {
		return this.userService.update(a);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.userService.deleteUser(id);
		
	}
	@GetMapping("info/{email}/{password}")
	public User getByInfo(@PathVariable String email,@PathVariable String password) {
		return this.userService.getByInfo(email,password);
	}

}
