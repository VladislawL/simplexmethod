package com.logvin.simplexmethod.routes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logvin.simplexmethod.algorithm.SimplexMethod;
import com.logvin.simplexmethod.algorithm.SimplexTable;

/**
 * Servlet implementation class SolutionServlet
 */

//@WebServlet("/solution")
public class SolutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/solution.jsp";
		HttpSession session = request.getSession();
		int type = Integer.parseInt(request.getParameter("maxmin"));
		doCalc(request, response, (Integer)session.getAttribute("n"), (Integer)session.getAttribute("m") + 1, type);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void doCalc(HttpServletRequest request, HttpServletResponse response, int n, int m, int type) {
		double[][] limitTable = new double[n][m];
		double[] function = new double[m - 1];
		for(int i = 0; i < n; i++)
			limitTable[i][0] = Double.parseDouble(request.getParameter("b" + i)) * 
									Double.parseDouble(request.getParameter("condition" + i)) * type;
		for(int i = 0; i < n; i++)
			for(int j = 1; j < m; j++)
				limitTable[i][j] =  Double.parseDouble(request.getParameter(i + "" + (j - 1))) * 
									Double.parseDouble(request.getParameter("condition" + i)) * type;
		for(int i = 0; i < m - 1; i++)
			function[i] = Double.parseDouble(request.getParameter("f" + i));
		
		
		SimplexMethod simplexMethod = new SimplexMethod(function, limitTable, type);
		List<SimplexTable> tables = simplexMethod.solveSimplexMethod();
		double[][] optimalTable = tables.get(tables.size() - 1).getTable();
		List<Integer> basisVariables = tables.get(tables.size() - 1).getBasisVariables();
		request.getSession().setAttribute("optimalTable", optimalTable);
		request.getSession().setAttribute("basisVariables", basisVariables.toArray());
	} 
	
}
