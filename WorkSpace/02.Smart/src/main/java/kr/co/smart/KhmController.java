package kr.co.smart;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/khm")
public class KhmController {
	
	@Autowired @Qualifier("hanul")
	SqlSession sql;
	
	@RequestMapping("/list")
	public void list() {
	}

}
