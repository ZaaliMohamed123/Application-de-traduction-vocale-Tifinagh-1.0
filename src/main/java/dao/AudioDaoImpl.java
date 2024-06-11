package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import beans.Audio;
import beans.User;

public class AudioDaoImpl implements AudioDao{
	private Connection cnx ;
	
	public AudioDaoImpl() {
		cnx = SingletonConnection.getConnection();
	}
	
	
	
	public void insert(Audio audio,User u) {
		
		try {
			String query = "INSERT INTO audiotifinagh (AudioName, AudioSizeInKb, AudioExtension, AudioContent,UserId) VALUES (?, ?, ?, ?,?)";
			PreparedStatement statement = cnx.prepareStatement(query);
			// Set parameters for the PreparedStatement
            statement.setString(1, audio.getAudioName());
            statement.setInt(2, audio.getAudioSizeInKb());
            statement.setString(3, audio.getAudioExtension());
            statement.setBytes(4, audio.getAudioContent());
            statement.setInt(5, u.getUserId());
            // Execute the query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Audio inserted successfully.");
            }

		} catch (Exception e) {
			System.out.println("Error inserting audio: " + e.getMessage());
            e.printStackTrace();
		}
        
    }
	
	public void insertTranslatedAudio(Audio a,int AudioTifinaghId) {
		try {
			
	        String disableFKChecks = "SET FOREIGN_KEY_CHECKS=0";
	        PreparedStatement disableStatement = cnx.prepareStatement(disableFKChecks);
	        disableStatement.executeUpdate();
	        
	        
			String query = "INSERT INTO audiotranslated (AudioTrName,AudioLanguage, AudioSizeInKb, AudioExtension, AudioContent,AudioTifinaghId) VALUES (?, ?, ?, ?,?,?)";
			PreparedStatement statement = cnx.prepareStatement(query);
			
            statement.setString(1, a.getAudioName());
            statement.setString(2, a.getAudioLanguage());
            statement.setInt(3, a.getAudioSizeInKb());
            statement.setString(4, a.getAudioExtension());
            statement.setBytes(5, a.getAudioContent());
            statement.setInt(6, AudioTifinaghId);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Audio inserted successfully.");
            }
            
            
            String enableFKChecks = "SET FOREIGN_KEY_CHECKS=1";
            PreparedStatement enableStatement = cnx.prepareStatement(enableFKChecks);
            enableStatement.executeUpdate();
            
            

		} catch (Exception e) {
			System.out.println("Error inserting audio: " + e.getMessage());
            e.printStackTrace();
		}
	}

	
	
	public Audio selectAudioByName(String AudioName) {
		Audio audio = null;
        
        try {
        	 String query = "SELECT * FROM audiotifinagh WHERE AudioName = ?";
        	 PreparedStatement statement = cnx.prepareStatement(query);
        	 
        	 statement.setString(1, AudioName);

             ResultSet resultSet = statement.executeQuery();

             while (resultSet.next()) {
            	 int audioId = resultSet.getInt("AudioId");
                 String audioName = resultSet.getString("AudioName");
                 int audioSizeInKb = resultSet.getInt("AudioSizeInKb");
                 String audioExtension = resultSet.getString("AudioExtension");
                 byte[] audioContent = resultSet.getBytes("AudioContent");

                 audio = new Audio(audioId, audioName, audioSizeInKb, audioExtension, audioContent);
             }
             
		} catch (Exception e) {
			System.out.println("Error selecting audio by AudioId: " + e.getMessage());
            e.printStackTrace();
		}
        return audio;
	}
	
	public Audio selectAudioByNameByUser(String AudioName,User u) {
		Audio audio = null;
        
        try {
        	 String query = "SELECT * FROM audiotifinagh WHERE AudioName = ? and userId = ?";
        	 PreparedStatement statement = cnx.prepareStatement(query);
        	 
        	 statement.setString(1, AudioName);
             statement.setInt(2, u.getUserId());

             ResultSet resultSet = statement.executeQuery();

             while (resultSet.next()) {
            	 int audioId = resultSet.getInt("AudioId");
                 String audioName = resultSet.getString("AudioName");
                 int audioSizeInKb = resultSet.getInt("AudioSizeInKb");
                 String audioExtension = resultSet.getString("AudioExtension");
                 byte[] audioContent = resultSet.getBytes("AudioContent");

                 audio = new Audio(audioId, audioName, audioSizeInKb, audioExtension, audioContent);
             }
             
		} catch (Exception e) {
			System.out.println("Error selecting audio by AudioId: " + e.getMessage());
            e.printStackTrace();
		}
        return audio;
	}

	
	public List<Audio> selectAllAudioTifByUser(int userId) {
        List<Audio> audioList = new ArrayList<>();
        String query = "SELECT * FROM audiotifinagh WHERE UserId = ?";

        try {
             PreparedStatement statement = cnx.prepareStatement(query);

            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int audioId = resultSet.getInt("AudioId");
                String audioName = resultSet.getString("AudioName");
                String audioExtension = resultSet.getString("AudioExtension");
                int audioSizeInKb = resultSet.getInt("AudioSizeInKb");
                byte[] audioContent = resultSet.getBytes("AudioContent");

                Audio audio = new Audio(audioId, audioName, audioSizeInKb, audioExtension, audioContent);

                audioList.add(audio);
            }

        } catch (SQLException e) {
            System.out.println("Error selecting audio by UserId: " + e.getMessage());
            e.printStackTrace();
        }

        return audioList;
    }
	
	
	
	public List<Audio> selectAllTrAudiosByName(String audioTrName) {
	    List<Audio> audioList = new ArrayList<>();
	    String query = "SELECT * FROM audiotranslated WHERE AudioTrName = ?";

	    try {
	        PreparedStatement statement = cnx.prepareStatement(query);

	        statement.setString(1, audioTrName);

	        ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	            int audioTrId = resultSet.getInt("AudioTrId");
	            String audioLanguage = resultSet.getString("AudioLanguage");
	            int audioSizeInKB = resultSet.getInt("AudioSizeInKB");
	            String audioExtension = resultSet.getString("AudioExtension");
	            byte[] audioContent = resultSet.getBytes("AudioContent");

	            Audio audio = new Audio(audioTrId, audioTrName, audioLanguage, audioSizeInKB, audioExtension, audioContent);

	            audioList.add(audio);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error selecting audio by name from audiotranslated table: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return audioList;
	}

	
	
	public Audio selectTrAudioByAudioTifNameByLanguage(String audioTifinaghName,String Language) {
		Audio audio = null;
		String query = "SELECT at.AudioTrId, at.AudioTrName, at.AudioLanguage, at.AudioSizeInKB, at.AudioExtension, at.AudioContent "
                + "FROM audiotranslated at , audiotifinagh atif where at.AudioTrName = atif.AudioName "
				+ " and atif.AudioName= ? and at.AudioLanguage = ?";
        
        try {
             PreparedStatement statement = cnx.prepareStatement(query);

             statement.setString(1, audioTifinaghName);
            statement.setString(2, Language);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int audioTrId = resultSet.getInt("AudioTrId");
                String audioTrName = resultSet.getString("AudioTrName");
                String audioLanguage = resultSet.getString("AudioLanguage");
                int audioSizeInKB = resultSet.getInt("AudioSizeInKB");
                String audioExtension = resultSet.getString("AudioExtension");
                byte[] audioContent = resultSet.getBytes("AudioContent");

                audio = new Audio(audioTrId, audioTrName, audioLanguage, audioSizeInKB, audioExtension, audioContent);

                
            }

        } catch (SQLException e) {
            System.out.println("Error selecting translated audio by AudioTifinaghId: " + e.getMessage());
            e.printStackTrace();
        }

        return audio;
    }

	public void delete(int audioId) {
	    String disableFKChecks = "SET FOREIGN_KEY_CHECKS = 0";
	    String enableFKChecks = "SET FOREIGN_KEY_CHECKS = 1";
	    String deleteQuery = "DELETE FROM audiotifinagh WHERE AudioId = ?";

	    try {
	        PreparedStatement disableStmt = cnx.prepareStatement(disableFKChecks);
	        disableStmt.execute();

	        PreparedStatement deleteStmt = cnx.prepareStatement(deleteQuery);
	        deleteStmt.setInt(1, audioId);

	        int rowsDeleted = deleteStmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Audio with AudioId " + audioId + " deleted successfully.");
	        } else {
	            System.out.println("No audio found with AudioId " + audioId + ". Nothing deleted.");
	        }

	        PreparedStatement enableStmt = cnx.prepareStatement(enableFKChecks);
	        enableStmt.execute();

	    } catch (SQLException e) {
	        System.out.println("Error deleting audio by AudioId: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
