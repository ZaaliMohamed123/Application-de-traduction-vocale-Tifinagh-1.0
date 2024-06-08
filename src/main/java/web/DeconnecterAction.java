package web;

import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeconnecterAction extends Action{

	public DeconnecterAction(Facade facade) {
		super(facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		// Invalidate the session to remove all attributes especially user attribute
        req.getSession().invalidate();
        
        return "index.html" ;

	}

}
