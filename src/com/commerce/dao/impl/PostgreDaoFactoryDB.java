package com.commerce.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.commerce.dao.DaoFactory;
import com.commerce.dao.DaoFactoryException;
import com.commerce.dao.UserDao;

public class PostgreDaoFactoryDB extends DaoFactory{
	
/*	public PostgreDaoFactoryDB() throws DaoFactoryException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			throw new DaoFactoryException(e);
		}
	}*/
	
	private Connection conn = null;
	
	private Connection getConnection() throws DaoFactoryException {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
            catch (SQLException e) {
            	throw new DaoFactoryException(e.getMessage());
            }
		}
		return conn;
	}
	
	public void closeConnection() {
		if (conn != null) {
			try {
    			conn.close();
    			conn = null;
			}
            catch (SQLException e) {
            	throw new DaoFactoryException(e.getMessage());
            }
		}
	}
	
	private Properties loadProperties( ) {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DaoFactoryException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {  //Para fechar o statement aberto no Program
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DaoFactoryException(e.getMessage());
			}
		}
    }
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DaoFactoryException(e.getMessage());
			}
		}
    }

	@Override
	public UserDao createUserDao() throws DaoFactoryException {
		return new PostgreUserDao(getConnection());
	}
}