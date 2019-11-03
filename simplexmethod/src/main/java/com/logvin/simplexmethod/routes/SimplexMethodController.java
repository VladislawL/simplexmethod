package com.logvin.simplexmethod.routes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimplexMethodController
 */

@WebServlet("/simplexTable")
public class SimplexMethodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String defaultUrl = "/SimplexTable.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = defaultUrl;
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		session.setAttribute("n", Integer.parseInt(request.getParameter("n")));
		session.setAttribute("m", Integer.parseInt(request.getParameter("m")));
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
