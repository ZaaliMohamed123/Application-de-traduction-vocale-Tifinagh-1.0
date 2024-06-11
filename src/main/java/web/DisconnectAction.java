package web;

import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisconnectAction extends Action {

	public DisconnectAction(Facade facade) {
		super(facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
    	
        // Remove the user attribute manually
        req.getSession().removeAttribute("user");

        // Invalidate the session to remove all attributes
        req.getSession().invalidate();

        return "index.html";
	}

}
