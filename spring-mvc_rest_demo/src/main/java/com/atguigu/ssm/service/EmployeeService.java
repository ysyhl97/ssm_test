package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;

import java.util.Collection;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.service
 * @CreateTime 2022-09-02  10:25
 * @email ttswbqz@gmail.com
 * @Description
 */
public interface EmployeeService {
	/**
	 * 查询所有用户信息
	 *
	 * @return
	 */
	Collection<Employee> getAll();

	/**
	 * 添加方法
	 */
	void save(Employee employee);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	Employee get(Integer id);

	/**
	 * 根据id删除员工信息
	 * @param id
	 */
	void delete(Integer id);
}
