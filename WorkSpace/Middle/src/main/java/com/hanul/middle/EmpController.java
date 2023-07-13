package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import employees.EmployeesVO;

@RestController
public class EmpController {

	@Autowired @Qualifier("hr")
	SqlSession sql;
	
	@RequestMapping(value = "/list.emp", produces = "text/html;charset=utf-8")
	public String list() {
		List<EmployeesVO> list = sql.selectList("emp.list");
		Gson gson = new Gson();
		return gson.toJson(list);
		
	}
	
}
