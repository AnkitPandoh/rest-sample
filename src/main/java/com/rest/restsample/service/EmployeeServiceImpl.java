package com.rest.restsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rest.restsample.dao.IEmployeeDao;
import com.rest.restsample.model.EmployeeModel;
/**
 * Service class to handle business logic for the request 
 * delegated by Employee controller.
 * @author ankpando
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	@Cacheable("employee")
	public EmployeeModel getEmployeeById(Long id) {
		testCache();
		return employeeDao.getEmployeeById(id);
	}

	/**
	 * Deliberately delaying the process to show that first time response is
	 * delayed because it is not in cache.
	 */
	private void testCache() {
		try {
			long time = 2000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
