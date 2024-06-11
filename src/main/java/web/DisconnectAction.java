package web;

import business.Facade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DisconnectAction extends Action {

    public DisconnectAction(Facade facade) {
        super(facade);
    }

    @Override
    String execute(HttpServletRequest req, HttpServletResponse resp) {
    	//controlling caching behavior
    	resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        resp.setHeader("Pragma", "no-cache"); // HTTP 1.0
    	resp.setDateHeader("Expires", 0); // Proxies

        HttpSession session = req.getSession(); 
        session.removeAttribute("user"); 
        session.invalidate(); 
        
  

        return "index.html"; 
    }

    
}
