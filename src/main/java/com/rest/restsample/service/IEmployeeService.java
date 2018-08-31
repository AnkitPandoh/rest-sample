package com.rest.restsample.service;

import com.rest.restsample.model.EmployeeModel;

public interface IEmployeeService {
	
	public EmployeeModel getEmployeeById(Long id);
}
