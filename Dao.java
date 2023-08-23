package de.zeroco.companycontacts.dao;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.zeroco.companycontacts.entity.Company;
import de.zeroco.companycontacts.entity.Contact;

public class Dao {

	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/apm?characterEncoding=utf8";
	public static final String USER = "admin";
	public static final String USER_PASSWORD = "@Chakri007";
	public static final String REGISTER_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * this method is used to  insert data to company table
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return id
	 */
	public static int save(Company company) {
		int companyId = 0;
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		companyId = DbUtility.getGeneratedKey(connection, "company_contacts", "company",
				Arrays.asList("name", "email", "phone", "address", "website"), Arrays.asList(company.getName(),
						company.getEmail(), company.getPhone(), company.getAddress(), company.getWebsite()));
		DbUtility.closeConnection(connection);
		return companyId;
	}

	/**
	 * this method is used to  delete  data of a company in the table
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return number of rows deleted
	 */
	public static int delete(Company company) {
		int rowsDeleted = 0;
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
	    rowsDeleted =	DbUtility.delete(connection, "company_contacts", "company", "pk_id", company.getId());
		DbUtility.closeConnection(connection);
		return rowsDeleted ;
	}

	/**
	 * this method is used to  get  the company data along with related contacts data with company
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return map
	 */
	public static Map<String, Object> get(Company company) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "company", Arrays.asList(), "pk_id",
				Arrays.asList(company.getId()));
		if(!Utility.isBlank(dataSet)) {
			List<Map<String, Object>> companyDataSet =	DbUtility.lists("company_contacts", "contacts", Arrays.asList(), "company_id", dataSet.get("pk_id"));
             dataSet.put("contacts", companyDataSet);
		}
		DbUtility.closeConnection(connection);
		return dataSet;
	}

	/**
	 * this method is used to  get the  company's list in the table
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return list of maps
	 */
	public static List<Map<String, Object>> list() {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		List<Map<String, Object>> dataSet = DbUtility.list("company_contacts", "company", Arrays.asList());
		for (Map<String, Object> map : dataSet) {
			if(!Utility.isBlank(map)) {
				List<Map<String, Object>> companyDataSet =	DbUtility.lists("company_contacts", "contacts", Arrays.asList(), "company_id", map.get("pk_id"));
	             map.put("contacts", companyDataSet);
			}
		}
		DbUtility.closeConnection(connection);
		return dataSet;
	}

	/**
	 * this method is used to  update data of a company table
	 * @author hari
	 * @since 2023-08-17
	 * @param company
	 * @return number of rows updated
	 */
	public static int update(Company company) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		int updatedRows =0; 
		updatedRows = DbUtility.update(connection, "company_contacts", "company",
				Arrays.asList("name", "email", "phone", "address", "website"), Arrays.asList(company.getName(),
						company.getEmail(), company.getPhone(), company.getAddress(), company.getWebsite()),
				"pk_id", company.getId());
		DbUtility.closeConnection(connection);
		return updatedRows;
	}

	/**
	 * this method is used to  insert data to contact table
	 * @author hari
	 * @since 2023-08-17
	 * @param contact
	 * @return id
	 */
	public static int save(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		int userId = 0;
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "company", Arrays.asList(), "name",
				Arrays.asList(contact.getCompanyName()));
		if ((!Utility.isBlank(dataSet))) {
			userId = DbUtility.getGeneratedKey(connection, "company_contacts", "contacts",
					Arrays.asList("name", "email", "phone", "address", "dateofbirth", "company_id"),
					Arrays.asList(contact.getName(), contact.getEmail(), contact.getPhone(), contact.getAddress(),
							contact.getDateOfBirth(), dataSet.get("pk_id")));
		}
		DbUtility.closeConnection(connection);
		return userId;
	}

	/**
	 * this method is used to  delete data of contact table
	 * @author hari
	 * @since 2023-08-17
	 * @param contact
	 * @return number of rows deleted
	 */
	public static int delete(Contact contact) {
		int rowsDeleted =0;
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		rowsDeleted = DbUtility.delete(connection, "company_contacts", "contacts", "pk_id", contact.getId());
		DbUtility.closeConnection(connection);
		return rowsDeleted;
	}
	
	/**
	 * this method is used to  get  the contact data  table
	 * @author hari
	 * @since 2023-08-17
	 * @param contact
	 * @return map
	 */
	public static Map<String, Object> get(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "contacts", Arrays.asList(), "pk_id",
				Arrays.asList(contact.getId()));
		DbUtility.closeConnection(connection);
		return dataSet;
	}
	
	/**
	 * this method is used to  get the contact list in the table
	 * @author hari
	 * @since 2023-08-17
	 * @param contact
	 * @return list of maps
	 */
	public static List<Map<String, Object>> getContactsList() {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		List<Map<String, Object>> dataSet = DbUtility.list("company_contacts", "contacts", Arrays.asList());
		DbUtility.closeConnection(connection);
		return dataSet;
	}
	
	/**
	 * this method is used to  update data of contact table
	 * @author hari
	 * @since 2023-08-17
	 * @param contact
	 * @return number of rows updated
	 */
	public static int update(Contact contact) {
		Connection connection = DbUtility.getConnection(DATABASE_URL, USER, USER_PASSWORD);
		int updatedRows = 0;
		Map<String, Object> dataSet = DbUtility.get(connection, "company_contacts", "company", Arrays.asList(), "name",Arrays.asList(contact.getCompanyName()));
		if(!Utility.isBlank(dataSet)) {
		  updatedRows = DbUtility.update(connection,  "company_contacts", "contacts",
					Arrays.asList("name", "email", "phone", "address", "dateofbirth", "company_id"), Arrays.asList(contact.getName(),
							contact.getEmail(), contact.getPhone(), contact.getAddress(), contact.getDateOfBirth(),dataSet.get("pk_id")),
					"pk_id", contact.getId());
		}
		DbUtility.closeConnection(connection);
		return updatedRows;
	}
}
