package com.commerce.dao;

import java.util.List;

import com.commerce.entities.User;

public interface UserDao {

	public void insertUser(User obj);
	public boolean isLoginValid(String email, String senha);
	public User findByEmail(String email);
	public void updateByEmail(User obj);
	public void updatePasswordByEmail(User obj);
	public void deleteByEmail(String email);  //Apagar depois de testar
	public List<User> findAll();  //Apagar depois de testar
}