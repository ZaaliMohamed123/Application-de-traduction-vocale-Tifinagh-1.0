package dao;

import java.util.List;

import beans.Audio;
import beans.User;

public interface AudioDao {
	
	public void insert(Audio a,User u);
	public void insertTranslatedAudio(Audio a,int AudioTifinaghId);
	public Audio selectAudioByName(String AudioName);
	public Audio selectAudioByNameByUser(String AudioName,User u);
	public List<Audio> selectAllAudioTifByUser(int userId);
	public List<Audio> selectAllTrAudiosByName(String audioTifName);
	public Audio selectTrAudioByAudioTifNameByLanguage(String audioTifinaghName,String Language);
	public void delete(int AudioId);
	
	
	
}
