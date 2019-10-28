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
 * Servlet implementation class Solution
 */

@WebServlet("/solution")
public class Solution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url;
			url = "/solution.jsp";
			String[] table = request.getParameterValues("table[]");
			String[] function = request.getParameterValues("func[]");
			for(String str : function) System.out.print(str + " ");
			for(String str : table) System.out.print(str + " ");
			System.out.println(request.getContextPath() + url);
			response.sendRedirect(request.getContextPath() + url);
			/*ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher(url);
			dispatcher.forward(request, response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
