package com.atguigu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ysyhl97
 * @version 1.0
 * @BelongsProject: ssm
 * @BelongsPackage: com.atguigu.ssm.controller
 * @CreateTime 2022-09-02  09:13
 * @email ttswbqz@gmail.com
 * @Description
 */
@Controller
public class TestRestfulController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getAllUser() {
		System.out.println("获取所有用户信息/user-->get");
		return "success";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getUserById(@PathVariable("id") Integer id) {
		System.out.println("查询用户信息,根据id:" + id);
		return "success";
	}

	@RequestMapping(value = "/user",method = RequestMethod.POST)
	public String insertUser(String username,String password){
		System.out.println("post方式添加用户信息,username:" + username+",password:"+password);
		return "success";
	}

	@RequestMapping(value = "/user",method = RequestMethod.PUT)
	public String updateUser(String username,Integer id){
		System.out.println("修改用户信息根据id:" + id+"修改用户名为:"+username);
		return "success";
	}

	@RequestMapping(value = "/user",method = RequestMethod.DELETE)
	public String deleteUser(Integer id){
		System.out.println("delete删除用户信息"+",id:"+id);
		return "success";
	}

}
