package com.commerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.commerce.dao.DaoFactoryException;
import com.commerce.dao.UserDao;
import com.commerce.entities.User;

import java.sql.Statement; //Muda conforme o BD

public class PostgreUserDao implements UserDao {

	private Connection conn;

	public PostgreUserDao(Connection conn) {  //Chama o BD
		this.conn = conn;
	}

	@Override
	public void insertUser(User obj) {
		PreparedStatement st = null;  //comando para recuperar os dados
		try {
			st = conn.prepareStatement( //Comando do BD
					"INSERT INTO usuario.usuario" 
					+"(nome, sobrenome, email, senha)" 
					+"VALUES"
					+"(?, ?, ?, ?)");
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getSurname());
			st.setString(3, obj.getEmail());
			st.setString(4, obj.getPassword());

			int rowsAffected = st.executeUpdate(); //Quando quero atualizar é int rowsAffected = st.executeUpdate()

		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
		}
	}
	
	
	@Override
	public boolean isLoginValid(String email, String senha) {
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			st = conn.prepareStatement("SELECT * FROM usuario.usuario WHERE email = ? AND senha = ? ");
			st.setString(1, email);
			st.setString(2, senha);
			rs = st.executeQuery(); //Quando só quero consultar é ResultSet rs = st.executeQuery()

			if (rs.next()) {
				//User user = new User();
				//user.setEmail(rs.getString("email"));
				//user.setPassword(rs.getString("senha"));
				return true;
			}
	
		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
			PostgreDaoFactoryDB.closeResultSet(rs);
		}
		return false;
	}
	
	
	@Override
	public User findByEmail(String email) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM usuario.usuario WHERE email = ?");
			st.setString(1, email);
			rs = st.executeQuery();

			if (rs.next()) {  //Enquanto existir um próximo, ele continua (lê a tabela em linhas)
				User obj = instantiateUser(rs);  //ver abaixo
				return obj;
			}
			return null;
		
		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
			PostgreDaoFactoryDB.closeResultSet(rs);
		}
	}
	

	private User instantiateUser(ResultSet rs) throws SQLException {
		User obj = new User();
		obj.setName(rs.getString("nome"));
		obj.setSurname(rs.getString("sobrenome"));
		obj.setPassword(rs.getString("senha"));
		obj.setEmail(rs.getString("email"));
     	//obj.setBirthDate(rs.getDate("BirthDate")); //instancia o java.sql.date
		//obj.setBirthDate(new java.util.Date(rs.getTimestamp("BirthDate").getTime())); //instancia o java.util.date
		return obj;
	}
	
	
	@Override
	public void updateByEmail(User obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE usuario.usuario " 
					+ " SET nome = ?, sobrenome = ?"
					+ "WHERE email = ? "); 
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getSurname());
			st.setString(3, obj.getEmail());
			
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
		}
	}

	
	@Override
	public void updatePasswordByEmail(User obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE usuario.usuario " 
					+ " SET senha = ? "
					+ "WHERE email = ? "); 
			
			st.setString(1, obj.getPassword());
			st.setString(2, obj.getEmail());
			
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
		}
	}
	
	
	//APAGAR DEPOIS DE TESTAR
	@Override
	public List<User> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * From usuario.usuario");

			rs = st.executeQuery();

			List<User> list = new ArrayList<>();
			
			while (rs.next()) {
				User obj = instantiateUser(rs);
				list.add(obj);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
			PostgreDaoFactoryDB.closeResultSet(rs);
		}
	}

	//APAGAR DEPOIS DE TESTAR
	@Override
	public void deleteByEmail(String email) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM usuario.usuario WHERE email = ?");

			st.setString(1, email);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DaoFactoryException(e.getMessage());
		} finally {
			PostgreDaoFactoryDB.closeStatement(st);
		}
	}
}
