package de.zeroco.companycontacts.service;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.zeroco.companycontacts.dao.Dao;
import de.zeroco.companycontacts.dao.DbUtility;
import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.entity.Company;

public class CompanyServices {

	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/apm?characterEncoding=utf8";
	public static final String USER = "admin";
	public static final String USER_PASSWORD = "@Chakri007";

	public static Company getObject(String name, String email, String phone, String address, String website) {
		return new Company(name, email, phone, address, website);
	}

	/**
	 * this method is used to validate the request data to insert
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return map
	 */
	public static Map<String, Object> save(Company company) {
		Map<String, Object> dataSet = DbUtility.get(DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD),
				"company_contacts", "company", Arrays.asList(), "phone", Arrays.asList(company.getPhone()));
		DbUtility.closeConnection(DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD));
		if ((Utility.isBlank(dataSet))) {
			Dao.save(company);
		}
		return dataSet;
	}
	
	/**
	 *  this method is used to validate the request data to delete
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return map
	 */
	public static Map<String, Object> delete(Company company) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "company", Arrays.asList("pk_id"),
				"pk_id", Arrays.asList(company.getId()));
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			Dao.delete(company);
		}
		return dataSet;
	}

	/**
	 *  this method is used to validate the request data to get row data
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return 
	 */
	public static Map<String, Object> get(Company company) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "company", Arrays.asList(), "pk_id",
				Arrays.asList(company.getId()));
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			return Dao.get(company);
		} else {
			return null;
		}
	}
	
	/**
	 *  this method is used to validate the request data to get list
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return 
	 */
	public static List<Map<String, Object>> list() {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		List<Map<String, Object>> dataSet = DbUtility.list("company_contacts", "company", Arrays.asList());
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			return Dao.list();
		} else {
			return null;
		}
	}
	
	/**
	 *  this method is used to validate the request data for update
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return 
	 */
	public static Map<String, Object> update(Company company) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "company", Arrays.asList(), "pk_id",
				Arrays.asList(company.getId()));
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			return dataSet;
		} else {
			return null;
		}
	}
}
