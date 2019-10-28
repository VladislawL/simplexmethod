package com.logvin.simplexmethod.routes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SolutionServlet
 */

@WebServlet("/solution")
public class SolutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] table = request.getParameterValues("table[]");
		String[] func = request.getParameterValues("func[]");
		String url = "/solution.jsp";
		if(table != null) System.out.println(table);
		if(func != null) System.out.println(func);
		/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);*/
		response.sendRedirect("solution.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
