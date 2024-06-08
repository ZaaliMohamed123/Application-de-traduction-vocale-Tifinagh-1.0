package business;

import dao.UserContact;
import dao.UserContactImpl;

public class UserContactManager implements UserContactBusiness{
	
	private UserContact us ; 
	
	public UserContactManager() {
		this.us = new UserContactImpl();
	}
	
	public UserContactManager(UserContact us) {
		this.us = us;
	}

	@Override
	public void addUserContact(String name, String email, String message) {
		us.insertUserContact(name, email, message);
	}

}
