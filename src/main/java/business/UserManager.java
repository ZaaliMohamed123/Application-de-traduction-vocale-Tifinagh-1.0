package business;

import beans.User;
import dao.UserDao;

public class UserManager implements UserBusiness{
	
	private UserDao udao ;
	
	public UserManager(){
		
	}
	
	public UserManager(UserDao udao) {
		this.udao = udao;
	}
	

	public UserDao getUdao() {
		return udao;
	}

	public void setUdao(UserDao udao) {
		this.udao = udao;
	}

	@Override
	public void addUser(User u) {
		udao.insert(u);
		
	}

	@Override
	public User getUser(String email, String passwd) {
		return udao.select(email, passwd);
	}
	
	public User getUser(int UserId) {
		return udao.select(UserId);
	}

}
