package de.zeroco.companycontacts.company_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.entity.Company;
import de.zeroco.companycontacts.service.CompanyServices;

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String userId = request.getParameter("userId");
		if (!Utility.isBlank(userId)) {
			Company company = new Company();
			company.setId(userId);
			Map<String, Object> dataSet = CompanyServices.delete(company);
			if (!Utility.isBlank(dataSet)) {
				writer.print("deleted sucessfully");
			} else {
				writer.print("enter valid user Id");
			}
		} else {
			writer.print("inefficient data");
		}
	}

}
