package com.hanul.exam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.CustomerVO;

@RestController
public class CustomerController {

	@Autowired
	@Qualifier("hanul")
	SqlSession sql;

	@RequestMapping("/list.cu")
	public String list() {
		List<CustomerVO> list = sql.selectList("cu.list");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName() + " " + list.get(i).getGender());
		}
		return "list";
	}

}
