package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;

import java.util.List;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.service
 * @CreateTime 2022-09-05  10:30
 * @email ttswbqz@gmail.com
 * @Description
 */
public interface EmployeeService {

	/**
	 * 查询所有员工信息
	 * @return
	 */
	List<Employee> getAllEmployee();

	/**
	 * 根据员工姓名模糊查询员工信息
	 * @param empName
	 * @return
	 */
	List<Employee> selectEmployeeLikeName(String empName);

	/**
	 * 根据员工id查询员工信息
	 * @param empId
	 * @return
	 */
	List<Employee> selectEmployeeById(Integer empId);

	/**
	 * 添加用户
	 * @param employee
	 * @return
	 */
	Integer insertEmployee(Employee employee);

	/**
	 * 修改用户信息
	 * @param employee
	 * @return
	 */
	Integer updateEmployee(Employee employee);

	/**
	 * 根据id删除员工信息
	 * @param empId
	 */
	void deleteEmployeeById(Integer empId);
}
