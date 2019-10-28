package com.logvin.simplexmethod.routes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimplexMethodController
 */

@WebServlet("/simplexTable/*")
public class SimplexMethodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String defaultUrl = "/SimplexTable.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String url = "";

		if(requestURI.endsWith("/solution")) {
			url = "/solution.jsp";
			/*String[] table = request.getParameterValues("table[]");
			String[] function = request.getParameterValues("func[]");
			for(String str : function) System.out.print(str + " ");
			for(String str : table) System.out.print(str + " ");*/
		}
		else url = defaultUrl;
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
