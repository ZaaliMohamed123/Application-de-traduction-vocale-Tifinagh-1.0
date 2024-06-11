package business;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserManager implements UserBusiness{
	
	private UserDao udao ;
	
	public UserManager(){
		udao = new UserDaoImpl();
		
	}
	
	

	@Override
	public void addUser(User u) {
		udao.insert(u);
		
	}

	@Override
	public User getUser(String email, String passwd) {
		return udao.select(email, passwd);
	}
	
	
}
