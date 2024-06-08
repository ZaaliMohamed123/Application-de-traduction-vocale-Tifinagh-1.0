package web;

import java.io.InputStream;

import beans.Audio;
import beans.User;
import business.Facade;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import utils.CreateAudio;

@MultipartConfig
public class UploadAction extends Action{

	public UploadAction(Facade facade) {
		super(facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(false);
		try {
			//Translation language 
			String language = req.getParameter("language");
			System.out.println(language);
			
	        // Get file part
	        
	        Part filePart = req.getPart("audioFile");
	        System.out.println(filePart);
	        
	        // Get file name and extension
	        String fileName = filePart.getSubmittedFileName();
	        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
	        String audioName = fileName.replace("."+CreateAudio.getFileExtension(fileName), "");
	        String AudioId = CreateAudio.extractAudioNumber(audioName);
			int AudioIdnum = Integer.parseInt(AudioId);

	        // Get file content
	        InputStream inputStream = filePart.getInputStream();
	        byte[] audioContent = inputStream.readAllBytes();

	        // Calculate file size in KB
	        int audioSizeInKb = (int) (audioContent.length / 1024);

	        // Create Audio object
	        Audio audio = new Audio();
	        audio.setAudioId(AudioIdnum);
	        audio.setAudioName(audioName);
	        audio.setAudioLanguage("Tif");
	        audio.setAudioSizeInKb(audioSizeInKb);
	        audio.setAudioExtension(fileExtension);
	        audio.setAudioContent(audioContent);
	        
	        
	        // Create User object
	        User user = (User) session.getAttribute("user");
	        System.out.println("user in upload  "+user);
	        
	        //Audio Test if exists
	        if(facade.selectAudioByNameByUser(audioName,user)!=null) {
	        	Audio a0 = facade.selectAudioByName(audioName);
	        	System.out.println(a0);
	        	Audio atr = facade.selectTrAudioByAudioTifNameByLanguage(a0.getAudioName(), language);
	        	System.out.println(atr);
		        req.setAttribute("AudioTifinagh", a0);
		        req.setAttribute("AudioTranslated", atr);
		        req.setAttribute("language", language);
	        	return "AudioAlreadyExistsPage.jsp";
	        }else {
	        	// Insert Audio object into database
	   	     
		        facade.insertAudio(audio,user);
		        
		        Audio a0 = facade.selectAudioByName(audioName);
		        Audio atr = facade.selectTrAudioByAudioTifNameByLanguage(a0.getAudioName(), language);
		        req.setAttribute("AudioTifinagh", a0);
		        req.setAttribute("AudioTranslated", atr);
		        req.setAttribute("language", language);
		        return "ResultUploadAudioPage.jsp" ;
	        }
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}

}
