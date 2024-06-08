package web;

import java.util.List;

import beans.Audio;
import beans.User;
import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayAudioAction extends Action{

	public DisplayAudioAction(Facade facade) {
		super(facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		User u = (User) req.getSession().getAttribute("user");
		String audioName = req.getParameter("audioName");
		Audio a = facade.selectAudioByNameByUser(audioName, u);
		List<Audio> trAudio = facade.selectAllTrAudiosByName(audioName);
		req.setAttribute("AudioTifinagh", a);
		req.setAttribute("AudiosTranslated", trAudio);
		
		return "DisplayAudio.jsp";
	}

}
