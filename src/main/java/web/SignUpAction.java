package web;

import beans.User;
import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpAction extends Action{

	public SignUpAction(Facade facade) {
		super(facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String passwd = req.getParameter("password");
		if(facade.selectUser(email, passwd)!=null) {
			return "AlreadyHaveAccountPage.html";
		}
		facade.ajouterUser(new User(name ,email, passwd));
		return "LoginPage.html";
	}

}
