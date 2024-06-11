package dao;

import beans.User;

public interface UserDao {
	
	public void insert(User u);
	public User select(String email,String passwd);
	

}
