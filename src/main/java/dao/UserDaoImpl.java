package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.User;


public class UserDaoImpl implements UserDao{
		private Connection cnx ;
	
	public UserDaoImpl() {
		cnx = SingletonConnection.getConnection();
	}
	
	@Override
	public void insert(User u) {
		try {
			String query = "INSERT INTO user (fullName,email, passwd) VALUES (?,?, ?)";
			PreparedStatement statement = cnx.prepareStatement(query);
			
			statement.setString(1, u.getFullName());
            statement.setString(2, u.getEmail());
            statement.setString(3, u.getPasswd());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
            	System.out.println("User inserted");
            }
		} catch (Exception e) {
			System.out.println("Error inserting user: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User select(String email, String passwd) {
		try {
			User user = null;
	        String query = "SELECT * FROM user WHERE email = ? and passwd = ?";
	        PreparedStatement statement = cnx.prepareStatement(query);
	        
	        statement.setString(1, email);
            statement.setString(2, passwd);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	int fetchedUserId = resultSet.getInt(1);
            	String fetchedFullName = resultSet.getString(2);
                String fetchedEmail = resultSet.getString("email");
                String fetchedPasswd = resultSet.getString("passwd");

                user = new User(fetchedUserId , fetchedFullName,fetchedEmail, fetchedPasswd);
            }
            return user;
		} catch (Exception e) {
			System.out.println("Error selecting user by email: " + e.getMessage());
            e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
