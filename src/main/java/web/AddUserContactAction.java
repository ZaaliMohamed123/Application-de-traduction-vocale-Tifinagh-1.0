package web;

import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUserContactAction extends Action{

	public AddUserContactAction(Facade facade) {
		super(facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		facade.insertUserContact(name, email, message);
		return "ThankYouPage.jsp";
	}

}
