package com.example.gestion_projet.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion_projet.models.User;
import com.example.gestion_projet.repository.UserRepo;
import com.example.gestion_projet.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	public User addUser(User a) {
		return this.userRepo.save(a);		
	}
	public void  deleteUser(Long id) {
		this.userRepo.deleteById(id);
	}
	public User getById(long id) {
		Optional<User>user= this.userRepo.findById(id);
		return user.isPresent()?user.get():null;
	}
	public List<User>getAllUser(){
		return this.userRepo.findAll();
	}
	public User update(User a) {
		return this.userRepo.save(a);
	}
	@Override
	public User getByInfo(String email,String password) {
		// TODO Auto-generated method stub
		return this.userRepo.findByInfo(email,password);
	}

}
