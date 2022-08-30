package com.example.gestion_projet.services;

import java.util.List;

import com.example.gestion_projet.models.User;

public interface UserService {
	public User addUser(User a);
	public void  deleteUser(Long id);
	public User getById(long id);
	public List<User>getAllUser();
	public User update(User a);
	public User getByInfo(String email,String password);

}
