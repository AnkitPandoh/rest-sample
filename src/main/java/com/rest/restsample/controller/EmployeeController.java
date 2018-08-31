package com.rest.restsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restsample.exception.InvalidInputException;
import com.rest.restsample.model.EmployeeModel;
import com.rest.restsample.service.IEmployeeService;

/**
 * <p>
 * Employee Controller which will handle all the request to perforn any kind of
 * operation on Employee
 * </p>
 * 
 * @author ankpando
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable String employeeId) {
		if (StringUtils.isEmpty(employeeId)) {
			throw new InvalidInputException("Employee Id can not be null or empty..");
		}
		Long id = null;
		try {
			id = Long.valueOf(employeeId);
		} catch (NumberFormatException ex) {
			throw new InvalidInputException("Please provide valid id");
		}
		EmployeeModel employee = employeeService.getEmployeeById(Long.valueOf(employeeId));
		return new ResponseEntity<EmployeeModel>(employee, HttpStatus.OK);
	}
}
