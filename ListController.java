package de.zeroco.companycontacts.company_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.service.CompanyServices;

public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		List<Map<String, Object>> dataSet = CompanyServices.list();
		if (!Utility.isBlank(dataSet)) {
			HttpSession session = request.getSession();
			session.setAttribute("DataSet", dataSet);
			RequestDispatcher dispatcher = request.getRequestDispatcher("companyList.jsp");
			dispatcher.forward(request, response);
		} else {
			writer.print("no data found");
		}
	}
}
