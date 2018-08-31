package com.rest.restsample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.restsample.model.EmployeeModel;
/**
 * Dao class to perform CRUD operations related to Employee
 * @author ankpando
 *
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private RowMapper<EmployeeModel> employeeMapper;

	@Override
	public EmployeeModel getEmployeeById(Long employeeId) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		EmployeeModel employee = jdbcTemplate.queryForObject(sql, employeeMapper, employeeId);
		return employee;
	}

}
