package com.rest.restsample.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rest.restsample.model.Address;
import com.rest.restsample.model.EmployeeModel;

@Component
public class EmployeeMapper implements RowMapper<EmployeeModel>{

	@Override
	public EmployeeModel mapRow(ResultSet row, int rownum) throws SQLException {
		EmployeeModel employee = new EmployeeModel();
		employee.setId(row.getLong("id"));
		employee.setFirstName(row.getString("fname"));
		employee.setLastName(row.getString("lname"));
		employee.setContactNumber(row.getString("contact"));
		
		Address address = new Address();
		address.setCity(row.getString("city"));
		address.setCountry(row.getString("city"));
		address.setZipCode(row.getString("zipcode"));
		
		employee.setAddress(address);
		return employee;
	}

}
