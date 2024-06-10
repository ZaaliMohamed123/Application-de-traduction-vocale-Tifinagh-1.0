package web;



import beans.User;
import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction extends Action{

	public LoginAction(Facade facade) {
		super(facade);
		
	}

	
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		String uri = req.getRequestURI();
		System.out.println(uri);
		String email = req.getParameter("email");
		String passwd = req.getParameter("password");
		User u = facade.selectUser(email, passwd);
		System.out.println(u);
		if(u!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			return "Home.jsp";
		}
		return "ErrorLoginPage.html";
	}
	

}
