package de.zeroco.companycontacts.company_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zeroco.companycontacts.dao.Dao;
import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.entity.Company;

public class SecondUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String website = request.getParameter("website");
		if ((!Utility.isBlank(userId)) & (!Utility.isBlank(name) & (!Utility.isBlank(email)) & (!Utility.isBlank(phone))
				& (!Utility.isBlank(address)) & (!Utility.isBlank(website)))) {
			Company company = new Company(userId, name, email, phone, address, website);
			int updatedColumns = Dao.update(company);
			if (updatedColumns > 0) {
				writer.print("upated sucessfully");
			} else {
				writer.print("not updated");
			}
		} else {
			writer.print("enter valid data");
		}
	}

}
