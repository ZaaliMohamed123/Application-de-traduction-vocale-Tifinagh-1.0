package business;

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
