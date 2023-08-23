package de.zeroco.companycontacts.company_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.entity.Company;
import de.zeroco.companycontacts.service.CompanyServices;

public class GetController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String userId = request.getParameter("userId");
		if (!Utility.isBlank(userId)) {
			Company company = new Company();
			company.setId(userId);
			Map<String, Object> dataSet = CompanyServices.get(company);
			if (!Utility.isBlank(dataSet)) {
				HttpSession session = request.getSession();
				session.setAttribute("dataSet", dataSet);
				RequestDispatcher dispatcher = request.getRequestDispatcher("companyDetails.jsp");
				dispatcher.forward(request, response);
			} else {
				writer.print("enter valid id for search");
			}
		} else {
			writer.print("enter value");
		}
	}

}
