package de.zeroco.companycontacts.company_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.entity.Company;
import de.zeroco.companycontacts.service.CompanyServices;

@SuppressWarnings("serial")
public class SaveController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String website = request.getParameter("website");
		if(!Utility.isBlank(name) & (!Utility.isBlank(email) & (!Utility.isBlank(phone) & (!Utility.isBlank(address) & (!Utility.isBlank(website)))))) {
            Company company = new Company(name, email, phone, address, website);
			 Map<String, Object> dataSet =   CompanyServices.save(company);
			 if((Utility.isBlank(dataSet))) {
				 writer.print("inserted sucessfully");
			 }else {
				 writer.print("user all ready exixsts");
			 }
		}else {
			writer.print("inefficient data");
		}
	}
}
