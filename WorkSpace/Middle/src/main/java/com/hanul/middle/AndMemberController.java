package com.hanul.middle;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import andmember.AndMemberDAO;
import andmember.AndMemberVO;

@RestController @RequestMapping("/and")
public class AndMemberController {
	
	@Autowired AndMemberDAO dao;
	
	@RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
	public String login(String id, String password) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("password", password);
		AndMemberVO vo = dao.login(params);
		return new Gson().toJson(vo);
	}
	
	

}
