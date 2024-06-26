package business;

import java.util.List;

import beans.Audio;
import beans.User;
import dao.AudioDao;
import dao.AudioDaoImpl;
import dao.UserContact;
import dao.UserContactImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class Facade {
	
	private UserBusiness ubusiness ;

	private AudioBusiness abusiness ;
	
	private UserContactBusiness ucbusiness ;

	public Facade() {
		
		ubusiness = new UserManager();
		
		abusiness = new AudioManager();
		
		ucbusiness = new UserContactManager();
	}
	
	public void ajouterUser(User u) {
		ubusiness.addUser(u);
	}
	public User selectUser(String email,String passwd) {
		return ubusiness.getUser(email, passwd);
	}
	
	
	
	
	public void insertAudio(Audio a,User u) {
		abusiness.add(a, u);
	}
	
	
	
	public Audio selectAudioByName(String AudioName) {
		return abusiness.getAudioByName(AudioName);
	}
	
	
	public List<Audio> selectAllTrAudiosByName(String audioTrName){
		return abusiness.getAllTrAudiosByName(audioTrName);
	}
	
	public List<Audio> selectAllAudioTifByUser(int userId){
		return abusiness.getAllAudioTifByUser(userId);
	}
	
	
	public Audio selectAudioByNameByUser(String AudioName , User u) {
		return abusiness.getAudioByNameByUser(AudioName, u);
	}
	
	public Audio selectTrAudioByAudioTifNameByLanguage(String audioTifinaghName,String Language) {
		return abusiness.getTrAudioByAudioTifNameByLanguage(audioTifinaghName, Language);
	}
	
	public void delete(int AudioId) {
		abusiness.remove(AudioId);
	}
	
	public void insertUserContact(String name , String email,String message) {
		ucbusiness.addUserContact(name, email, message);
	}
	
	
}
