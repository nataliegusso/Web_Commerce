package com.commerce.util;

import com.commerce.entities.User;
import com.commerce.manageBean.UserBo;

public class MainTemp {

	public static void main(String[] args){
		User user = new User();
		
		user.setEmail("teste@teste.com");
		user.setName("Name");
		user.setSurname("Surname");
		user.setPassword("123456");

		UserBo userbo = new UserBo();
		try {
			//userbo.insertUser(user);
			boolean userLogin = userbo.validateLogin("test123e@teste.com", "123456");
			System.out.println("----------> " + userLogin);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
