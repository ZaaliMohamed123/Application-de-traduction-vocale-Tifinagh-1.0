package beans;

public class User {
	private int userId;
	private String FullName ;
	private String email;
	private String passwd ;
	
	public User() {
		
	}
	
	
	public User(String fullName, String email, String passwd) {
		
		FullName = fullName;
		this.email = email;
		this.passwd = passwd;
	}






	public User(int userId, String fullName, String email, String passwd) {
		
		this.userId = userId;
		FullName = fullName;
		this.email = email;
		this.passwd = passwd;
	}






	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	public String getFullName() {
		return FullName;
	}


	public void setFullName(String fullName) {
		FullName = fullName;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", passwd=" + passwd + "]";
	}
	
	
	
	
}
