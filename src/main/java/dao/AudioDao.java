package dao;

import java.util.List;

import beans.Audio;
import beans.User;

public interface AudioDao {
	public void insert(Audio a);
	public void insert(Audio a,User u);
	public void insertTranslatedAudio(Audio a,int AudioTifinaghId);
	public Audio selectAudioById(int AudioId);
	public Audio selectAudioByName(String AudioName);
	public Audio selectAudioByNameByUser(String AudioName,User u);
	public List<Audio> selectAllAudioTifByUser(int userId);
	public List<Audio> selectAllTrAudio(int AudioTifId);
	public List<Audio> selectAllTrAudiosByName(String audioTifName);
	public Audio selectTrAudioByAudioTifIdByLanguage(int audioTifinaghId,String Language);
	public Audio selectTrAudioByAudioTifNameByLanguage(String audioTifinaghName,String Language);
	public void delete(int AudioId);
	
}
