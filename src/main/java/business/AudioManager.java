package business;

import java.util.ArrayList;
import java.util.List;

import beans.Audio;
import beans.User;
import dao.AudioDao;

public class AudioManager implements AudioBusiness{
	private AudioDao adao ;
	
	public AudioManager() {
		
	}


	public AudioManager(AudioDao adao) {
		this.adao = adao;
	}
	
	

	public AudioDao getAdao() {
		return adao;
	}



	public void setAdao(AudioDao adao) {
		this.adao = adao;
	}


	@Override
	public void add(Audio a) {
		adao.insert(a);
	}
	public void add(Audio a,User u) {
		adao.insert(a,u);
	}


	@Override
	public Audio getAudioByName(String AudioName) {
		return adao.selectAudioByName(AudioName);
	}
	
	public Audio getAudioByNameByUser(String AudioName , User u) {
		return adao.selectAudioByNameByUser(AudioName, u);
	}


	@Override
	public List<Audio> getAllTrAudio(int AudioTifId) {
		return adao.selectAllTrAudio(AudioTifId);
	}


	@Override
	public List<Audio> getAllTrAudiosByName(String audioTifName) {
		List<Audio> la = adao.selectAllTrAudiosByName(audioTifName) ;
		for(Audio a : la){
			if(a.getAudioLanguage().equals("Ang")) {
				a.setAudioLanguage("Anglais");
			}else if(a.getAudioLanguage().equals("Fr")) {
				a.setAudioLanguage("Français");
			}else {
				a.setAudioLanguage("Arabe");
			}
		}
		return la;
	}


	@Override
	public List<Audio> getAllAudioTifByUser(int userId) {
		return adao.selectAllAudioTifByUser(userId);
	}
	
	public List<Audio> getAllTrAudioByUser(int userId) {
		List<Audio> AllTrAudios = new ArrayList<Audio>();
		for(Audio a : adao.selectAllAudioTifByUser(userId)) {
			for(Audio atr : getAllTrAudiosByName(a.getAudioName())) {
				AllTrAudios.add(atr);
			}
		}	
		return AllTrAudios;
	}
	
	public List<Audio> getAllArTrAudioByUser(int userId) {
		List<Audio> AllArTrAudios = new ArrayList<Audio>();
		for(Audio a : getAllTrAudioByUser(userId)) {
			if(a.getAudioLanguage().equals("Ar")) {
				AllArTrAudios.add(a);
			}
		}
		return AllArTrAudios;
	}
	
	public List<Audio> getAllFrTrAudioByUser(int userId) {
		List<Audio> AllFrTrAudios = new ArrayList<Audio>();
		for(Audio a : getAllTrAudioByUser(userId)) {
			if(a.getAudioLanguage().equals("Fr")) {
				AllFrTrAudios.add(a);
			}
		}
		return AllFrTrAudios;
	}
	
	public List<Audio> getAllAngTrAudioByUser(int userId) {
		List<Audio> AllAngTrAudios = new ArrayList<Audio>();
		for(Audio a : getAllTrAudioByUser(userId)) {
			if(a.getAudioLanguage().equals("Ang")) {
				AllAngTrAudios.add(a);
			}
		}
		return AllAngTrAudios;
	}
	
	public Audio getTrAudioByAudioTifIdByLanguage(int audioTifinaghId,String Language){
		String lang = Language;
		if(lang.equals("Anglais")) {
			lang = "Ang";
		}else if(lang.equals("Français")) {
			lang="Fr";
		}else {
			lang="Ar";
		}
		return adao.selectTrAudioByAudioTifIdByLanguage(audioTifinaghId, lang);
	}


	@Override
	public Audio getTrAudioByAudioTifNameByLanguage(String audioTifinaghName, String Language) {
		String lang = Language;
		if(lang.equals("Anglais")) {
			lang = "Ang";
		}else if(lang.equals("Français")) {
			lang="Fr";
		}else {
			lang="Ar";
		}
		return adao.selectTrAudioByAudioTifNameByLanguage(audioTifinaghName, lang);
	}


	@Override
	public void remove(int AudioId) {
		adao.delete(AudioId);
	}



	

}
