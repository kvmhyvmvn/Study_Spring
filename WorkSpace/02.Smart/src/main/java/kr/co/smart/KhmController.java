package kr.co.smart;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.common.CommonUtility;
import smart.common.PageVO;
import smart.khm.KhmDAO;
import smart.member.MemberVO;

@Controller
@RequestMapping("/khm")
public class KhmController {
	@Autowired
	private KhmDAO service;
	@Autowired
	private CommonUtility common;
	
	// 목록 화면 요청
	@RequestMapping("/list")
	public String list(HttpSession session, PageVO page, Model model) {
		// 임시 로그인 처리
		String userid = "su123";
		String userpw = "Abc123";
//		MemberVO login = member.member_info(userid);
//		if (pw.matches(userpw, login.getUserpw())) {
			// session.setAttribute("loginInfo", login);
//		}
		model.addAttribute("page", service.khm_list(page));
		session.setAttribute("category", "khm");
		return "khm/list";
	}
	
	// 신규 입력 화면 요청
	@RequestMapping("/new")
	public String board() {
		return "khm/new";
	}
}
