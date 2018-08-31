package com.rest.restsample.dao;

import com.rest.restsample.model.EmployeeModel;

public interface IEmployeeDao {
	
	public EmployeeModel getEmployeeById(Long id);
}
