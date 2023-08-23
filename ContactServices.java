package de.zeroco.companycontacts.service;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.zeroco.companycontacts.dao.Dao;
import de.zeroco.companycontacts.dao.DbUtility;
import de.zeroco.companycontacts.dao.Utility;
import de.zeroco.companycontacts.entity.Contact;

public class ContactServices {

	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/apm?characterEncoding=utf8";
	public static final String USER = "admin";
	public static final String USER_PASSWORD = "@Chakri007";
	public static final String REGISTER_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * this method is used to validate the request data to insert
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return integer
	 */
	public static int save(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "contacts", Arrays.asList(),
				"phone", Arrays.asList(contact.getPhone()));
		if ((Utility.isBlank(dataSet))) {
			 return Dao.save(contact);
		}
		return 0;
	}

	/**
	 *  this method is used to validate the request data to delete
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return integer
	 */
	public static int delete(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "contacts", Arrays.asList(),
				"pk_id", Arrays.asList(contact.getId()));
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			 return Dao.delete(contact);
		} else {
			return 0;
		}
	}
	
	/**
	 *  this method is used to validate the request data to get row data
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return 
	 */
	public static Map<String, Object> get(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "contacts", Arrays.asList(), "pk_id",
				Arrays.asList(contact.getId()));
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			return Dao.get(contact);
		} else {
			return null;
		}
	}
	
	/**
	 *  this method is used to validate the request data for get list of contacts
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return 
	 */
	public static List<Map<String, Object>> list() {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		List<Map<String, Object>> dataSet = DbUtility.list("company_contacts", "contacts", Arrays.asList());
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			return Dao.getContactsList();
		} else {
			return null;
		}
	}
	
	/**
	 * this method is used to validate the request data to update
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return 
	 */
	public static Map<String, Object> update(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection,"company_contacts", "contacts", Arrays.asList(), "pk_id",
				Arrays.asList(contact.getId()));
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(dataSet))) {
			return dataSet;
		} else {
			return null;
		}
	}
	
	/**
	 *  this method is used to validate the request data to update
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return map
	 */
	public static Map<String, Object> getupdate(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String , Object> dataSet= update(contact);
		Map<String, Object> companyDataSet = null;
		if(!Utility.isBlank(dataSet)) {
		companyDataSet = DbUtility.get(connection,"company_contacts", "company", Arrays.asList(), "pk_id",
				Arrays.asList(dataSet.get("company_id")));
		}
		DbUtility.closeConnection(connection);
		if ((!Utility.isBlank(companyDataSet))) {
			return companyDataSet;
		} else {
			return null;
		}
	}
}
