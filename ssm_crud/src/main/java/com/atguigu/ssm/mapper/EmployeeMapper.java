package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.mapper
 * @CreateTime 2022-09-05  10:31
 * @email ttswbqz@gmail.com
 * @Description
 */
@Repository
public interface EmployeeMapper {
	/**
	 * 查询所有员工信息
	 * @return
	 */
	List<Employee> getAllEmployee();

	/**
	 * 根据用户名模糊查询用户信息
	 * @param empName
	 * @return
	 */
	List<Employee> selectEmployeeLikeName(String empName);

	/**
	 * 根究用户id查询用户信息
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
	 * 根据id删除用户信息
	 * @param empId
	 */
	void deleteEmployeeById(Integer empId);
}
