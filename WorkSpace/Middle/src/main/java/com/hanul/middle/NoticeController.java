package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import notice.NoticeVO;

@RestController
public class NoticeController {

	@Autowired
	@Qualifier("hanul")
	SqlSession sql;

	@RequestMapping("/one.nt")
	public String one(NoticeVO tmpVo) {
		NoticeVO vo = sql.selectOne("nt.one", tmpVo);
		System.out.println(vo.getTitle());
		return "one";
	}

	@RequestMapping("/list.nt")
	public String list() {
		List<NoticeVO> list = sql.selectList("nt.list");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		return "list";
	}
}
