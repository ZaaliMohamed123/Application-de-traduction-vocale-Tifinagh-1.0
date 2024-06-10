package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UserContactImpl implements UserContact{
	
	private Connection cnx ;
	
	

	public UserContactImpl() {
		cnx = SingletonConnection.getConnection();
	}



	@Override
	public void insertUserContact(String name, String email, String message) {
		String req = "insert into UserContact(name,email,message) values(?,?,?);" ;
		try {
			PreparedStatement pst = cnx.prepareStatement(req);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, message);

			
            int rowsInserted = pst.executeUpdate();
            if(rowsInserted > 0) {
            	System.out.println("UserContact inserted");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
