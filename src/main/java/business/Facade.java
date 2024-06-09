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
	private UserDao udao;
	private UserBusiness ubusiness ;
	private AudioDao adao ;
	private AudioBusiness abusiness ;
	private UserContact ucdao;
	private UserContactBusiness ucbusiness ;

	public Facade() {
		udao = new UserDaoImpl();
		ubusiness = new UserManager(udao);
		adao = new AudioDaoImpl();
		abusiness = new AudioManager(adao);
		ucdao = new UserContactImpl();
		ucbusiness = new UserContactManager(ucdao);
	}
	
	public void ajouterUser(User u) {
		ubusiness.addUser(u);
	}
	public User selectUser(String email,String passwd) {
		return ubusiness.getUser(email, passwd);
	}
	
	
	public void insertAudio(Audio a) {
		adao.insert(a);
	}
	
	public void insertAudio(Audio a,User u) {
		adao.insert(a,u);
	}
	
	public User selectUserById(int UserId) {
		return ubusiness.getUser(UserId);
	}
	
	public Audio selectAudioByName(String AudioName) {
		return abusiness.getAudioByName(AudioName);
	}
	
	public List<Audio> selectAllTrAudio(int AudioTifId){
		return abusiness.getAllTrAudio(AudioTifId);
	}
	
	public List<Audio> selectAllTrAudiosByName(String audioTrName){
		return abusiness.getAllTrAudiosByName(audioTrName);
	}
	
	public List<Audio> selectAllAudioTifByUser(int userId){
		return abusiness.getAllAudioTifByUser(userId);
	}
	
	public List<Audio> selectAllTrAudioByUser(int userId){
		return abusiness.getAllTrAudioByUser(userId);
	}
	public List<Audio> selectAllArTrAudioByUser(int userId){
		return abusiness.getAllArTrAudioByUser(userId);
	}
	public List<Audio> selectAllFrTrAudioByUser(int userId) {
		return abusiness.getAllFrTrAudioByUser(userId);
	}
	public List<Audio> selectAllAngTrAudioByUser(int userId){
		return abusiness.getAllAngTrAudioByUser(userId);
	}
	
	public Audio selectTrAudioByAudioTifIdByLanguage(int audioTifinaghId,String Language){
		return abusiness.getTrAudioByAudioTifIdByLanguage(audioTifinaghId, Language);
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