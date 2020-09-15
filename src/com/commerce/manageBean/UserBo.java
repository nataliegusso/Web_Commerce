package com.commerce.manageBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.commerce.dao.DaoFactory;
import com.commerce.dao.UserDao;
import com.commerce.entities.User;

public class UserBo {

	private DaoFactory factory;

	private UserDao userDao;

	public void insertUser(User u) throws Exception {
		factory = DaoFactory.getInstance();
		userDao = factory.createUserDao();
		//close

		userDao.insertUser(u);
		//return result;
	}

	public boolean validateLogin(String email, String senha) throws Exception {
		factory = DaoFactory.getInstance();
		userDao = factory.createUserDao();
		//close

		return (userDao.isLoginValid(email, senha));
	}
	
/*	public boolean validateLogin(String email, String senha) throws Exception{
		String sql = "select * from usuario.usuario where email = '" + email + "' and senha = '" + senha + "'";
	    PreparedStatement statement = connection.prepareStatement(sql);
	    ResultSet resultSet = statement.executeQuery();
	    if (resultSet.next()) {
	    	return true; //se encontrar um usuário cadastrado
	    }else {
	    	return false;
	    }
	}*/
	
	
/*    public boolean validarLoginSenha (String login, String senha) {	//Método para validar senha
        if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
        	return true;
        }else {
            return false;
        }
    }*/
}
