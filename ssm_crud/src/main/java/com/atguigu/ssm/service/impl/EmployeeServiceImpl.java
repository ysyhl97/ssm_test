package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.service.impl
 * @CreateTime 2022-09-05  10:30
 * @email ttswbqz@gmail.com
 * @Description
 */
@Service
@Transactional(rollbackFor = ArithmeticException.class)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeMapper.getAllEmployee();
	}

	@Override
	public List<Employee> selectEmployeeLikeName(String empName) {
		return employeeMapper.selectEmployeeLikeName(empName);
	}

	@Override
	public List<Employee> selectEmployeeById(Integer empId) {

		return employeeMapper.selectEmployeeById(empId);
	}

	@Override
	public Integer insertEmployee(Employee employee) {
		return employeeMapper.insertEmployee(employee);
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		employeeMapper.deleteEmployeeById(empId);
	}
}
