package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SCommand {
	
	public void execte(HttpServletRequest request, HttpServletResponse response);

}
