package com.atguigu.ssm.controller;

import com.atguigu.ssm.dao.EmployeeDao;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.server.RMIClassLoader;
import java.util.Collection;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.controller
 * @CreateTime 2022-09-02  10:24
 * @email ttswbqz@gmail.com
 * @Description
 */
@Controller
public class RestfulController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String getAllEmp(Model model) {
		Collection<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "employee_list";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String insertEmp(Employee employee) {
		// 保存添加用户信息到
		employeeService.save(employee);
		return "redirect:/emp";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
		// 通过id查询到员工对象
		Employee employee = employeeService.get(id);
		System.out.println(employee);
		// 将员工信息回显到修改页面
		model.addAttribute("employee", employee);
		// 跳转到修改页面
		return "employee_update";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String UpdateEmp(Employee employee) {
		// 将修改后的数据保存
		System.out.println(employee);
		employeeService.save(employee);
		// 重新返回查询列表
		return "redirect:/emp";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id"
	) Integer id) {
		employeeService.delete(id);
		return "redirect:/emp";
	}

}
