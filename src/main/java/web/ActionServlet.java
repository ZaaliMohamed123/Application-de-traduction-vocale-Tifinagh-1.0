package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import business.Facade;




@SuppressWarnings("serial")
@MultipartConfig
public class ActionServlet extends HttpServlet{
	private Facade facade ;
	private Map<String, Action> actions ;

	@Override
	public void init() throws ServletException {
		facade = new Facade();
		actions = new HashMap<String, Action>();
		actions.put("Login", new LoginAction(facade));
		actions.put("SignUp", new SignUpAction(facade));
		actions.put("Upload", new UploadAction(facade));
		actions.put("Deconnecter", new DeconnecterAction(facade));
		actions.put("Historique", new HistoriqueAction(facade));
		actions.put("DisplayAudio", new DisplayAudioAction(facade));
		actions.put("DeleteAudio", new DeleteAudioAction(facade));
		actions.put("AddUserContact", new AddUserContactAction(facade));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI() ;
		String key = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".do"));
		Action action = actions.get(key);
		String view = action.execute(req, resp);
		req.getRequestDispatcher(view).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
