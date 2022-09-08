package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.dao.impl.EmployeeDaoImpl;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.service.impl
 * @CreateTime 2022-09-02  10:27
 * @email ttswbqz@gmail.com
 * @Description
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;


	@Override
	public Collection<Employee> getAll() {
		Collection<Employee> employees = employeeDao.getAll();
		return employees;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public Employee get(Integer id) {
		Employee employee = employeeDao.get(id);
		return employee;
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);
	}
}
