package com.example.gestion_projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gestion_projet.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.Email= :email AND u.Password= :password ")
	public User findByInfo(@Param(value = "email") String email,@Param(value = "password") String password);

}
