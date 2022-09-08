package com.atguigu.ssm.dao.impl;

import com.atguigu.ssm.dao.EmployeeDao;
import com.atguigu.ssm.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.dao.impl
 * @CreateTime 2022-09-02  10:26
 * @email ttswbqz@gmail.com
 * @Description
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static Map<Integer, Employee> employees = null;

	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
	}

	private static Integer initId = 1006;

	public void save(Employee employee) {
		if (employee.getId() == null) {
			employee.setId(initId++);
		}
		employees.put(employee.getId(), employee);
	}

	public Collection<Employee> getAll(){ return employees.values();
	}
	public Employee get(Integer id){ return employees.get(id);
	}
	public void delete(Integer id){ employees.remove(id);
	}
}
