package application;

import java.util.List;

import com.commerce.dao.UserDao;
import com.commerce.entities.User;
import com.commerce.manageBean.UserBo;

public class Program {

	
	public static void main(String[] args) {
		Program p = new Program();
		p.run();
	}
	
	public void run() {
		User newUser = new User("Teste", "Testesilva");
		
		user.setEmail("teste@teste.com");
		user.setName();
		user.setSurname();
		user.setPassword("123456");
	
		UserBo userbo = new UserBo();
		try {
			userbo.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//DaoFactory factory = DaoFactory.getInstance();
		//UserDao userDao = factory.createUserDao();
		//UserBo userbo = new UserBo();
		UserDao userDao = UserBo.insertUser(user)
		
		System.out.println("TESTE findAll");
		List<User> list = userDao.findAll();
		for (User obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTESTE insertUser");
		User newUser = new User("Ana", "Costa", "ana@gmail.com", "987456");
		userDao.insertUser(newUser);
		System.out.println("Inserted!");
				
		System.out.println("\nTESTE isLoginValid");
		User login = userDao.isLoginValid("maria@gmail.com", "123789");
		System.out.println(login);
		
		System.out.println("\nTESTE Upload");
		//User user = new User();
		user = userDao.findByEmail("laura@gmail.com");
		user.setName("Laura");
		user.setSurname("Pereira");
		userDao.updateByEmail(user);
		System.out.println("Update completed");

		System.out.println("\nTESTE Change Password");
		user = userDao.findByEmail("maria@gmail.com");
		user.setPassword("123789");
		userDao.updatePasswordByEmail(user);
		System.out.println("Update completed");
				
		System.out.println("\nTESTE findAll");
		list = userDao.findAll();
		for (User obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTESTE DeleteByEmail");
		userDao.deleteByEmail("ana@gmail.com");
		System.out.println("Deleted!");
	
		System.out.println("TESTE findAll");
		list = userDao.findAll();
		for (User obj : list) {
			System.out.println(obj);
		}
		
        //Fazer o que o site faz
		
	}
}