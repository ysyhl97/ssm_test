package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.controller
 * @CreateTime 2022-09-05  10:21
 * @email ttswbqz@gmail.com
 * @Description
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		List<Employee> employeeList = employeeService.getAllEmployee();
		System.out.println(employeeList);
		model.addAttribute("employeeList", employeeList);
		return "employee_list";
	}

	@RequestMapping(value = "/employee/page/{pageNumber}", method = RequestMethod.GET)
	public String getAllPageEmployee(@PathVariable("pageNumber") Integer pn, Model model) {
		// 开启分页功能
		PageHelper.startPage(pn, 30);
		// 获取分页数据
		List<Employee> list = employeeService.getAllEmployee();
		PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
		// 分页后的数据,存入域对象
		model.addAttribute("pageInfo", pageInfo);
		return "employee_list";
	}

	@RequestMapping(value = "/employee/ss", method = RequestMethod.GET)
	public String selectEmployeeLikeName(String empName, Model model) {
		PageHelper.startPage(1, 20);
		List<Employee> list = employeeService.selectEmployeeLikeName(empName);
		PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("**************************"+empName);
		return "forward:/toQuery";
	}


	@RequestMapping(value = "/employee/page/page/{pageNumber}", method = RequestMethod.GET)
	public String selectEmployeeById(@PathVariable(value = "pageNumber") Integer pn, Integer empId, Model model) {
		PageHelper.startPage(pn, 30);
		List<Employee> list = employeeService.selectEmployeeById(empId);
		PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
		model.addAttribute("pageInfo", pageInfo);
		return "employee_select";

	}

	@RequestMapping(value = "/to/update/{empId}",method = RequestMethod.GET)
	public String toUpdate(@PathVariable("empId") Integer empId,Model model){
		for (Employee employee : employeeService.selectEmployeeById(empId)) {
			model.addAttribute("employee",employee);
		}

		return "employee_update";
	}

	@RequestMapping(value = "/employee",method = RequestMethod.POST)
	public String insertEmployee(Employee employee){

		System.out.println(employee);
		Integer i = employeeService.insertEmployee(employee);
		return "redirect:/employee/page/1";
	}

	@RequestMapping(value = "/employee",method = RequestMethod.PUT)
	public String updateEmployee(Employee employee,Model model){
		Integer i = employeeService.updateEmployee(employee);
		return "redirect:/employee/page/1";
	}

	@RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
	public String deleteEmployeeById(@PathVariable("empId") Integer empId){
		employeeService.deleteEmployeeById(empId);
		return "redirect:/employee/page/1";

	}

}
