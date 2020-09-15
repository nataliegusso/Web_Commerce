package com.commerce.dao;

import com.commerce.dao.DaoFactory;
import com.commerce.dao.DaoFactoryException;
import com.commerce.dao.impl.PostgreDaoFactoryDB;

public abstract class DaoFactory {

	private static DaoFactory instance;
	
	public static DaoFactory getInstance() throws DaoFactoryException {
		if (instance == null) {
			instance = new PostgreDaoFactoryDB();
		}
		return instance;
	}
	
	public abstract UserDao createUserDao();

}
