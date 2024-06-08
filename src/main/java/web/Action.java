package web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import business.Facade;

public abstract class Action {
	Facade facade ;
	
	public Action(Facade facade) {
		this.facade = facade ;
	}
	
	abstract String execute(HttpServletRequest req , HttpServletResponse resp);
}
