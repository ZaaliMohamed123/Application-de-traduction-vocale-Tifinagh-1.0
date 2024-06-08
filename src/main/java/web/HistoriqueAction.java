package web;

import java.util.List;

import beans.Audio;
import beans.User;
import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HistoriqueAction extends Action{

	public HistoriqueAction(Facade facade) {
		super(facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		List<Audio> AudioTif = facade.selectAllAudioTifByUser(u.getUserId());
		req.setAttribute("AudioTifinagh", AudioTif);
		return "Historique.jsp";
	}

}
