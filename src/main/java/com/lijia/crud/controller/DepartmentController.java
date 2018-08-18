package com.lijia.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lijia.crud.bean.Department;
import com.lijia.crud.bean.Msg;
import com.lijia.crud.service.DepartmentService;

/**
 * 处理部门信息的控制器
 * @author 李嘉
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 返回部门信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDeptInfo(Model model) {
	
		//查询私有的部门信息
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
	
	
}
