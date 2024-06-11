package business;

import beans.User;

public interface UserBusiness {

	public void addUser(User u);
	public User getUser(String email,String passwd);
	
}
