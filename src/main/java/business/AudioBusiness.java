package business;

import java.util.List;

import beans.Audio;
import beans.User;

public interface AudioBusiness {

	public void add(Audio a);
	public void add(Audio a,User u);
	public Audio getAudioByName(String AudioName);
	public Audio getAudioByNameByUser(String AudioName , User u);
	public List<Audio> getAllTrAudio(int AudioTifId);
	public List<Audio> getAllTrAudiosByName(String audioTrName);
	public List<Audio> getAllAudioTifByUser(int userId);
	public List<Audio> getAllTrAudioByUser(int userId) ;
	public List<Audio> getAllArTrAudioByUser(int userId) ;
	public List<Audio> getAllFrTrAudioByUser(int userId) ;
	public List<Audio> getAllAngTrAudioByUser(int userId) ;
	public Audio getTrAudioByAudioTifIdByLanguage(int audioTifinaghId,String Language);
	public Audio getTrAudioByAudioTifNameByLanguage(String audioTifinaghName,String Language);
	public void remove(int AudioId);
	
}
