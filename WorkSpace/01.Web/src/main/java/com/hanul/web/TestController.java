package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import customer.CustomerVO;

@Controller
public class TestController {

	@RequestMapping("/joinPath/{name}/{gender}/{mail}/{age}")
	public String join(@PathVariable String name, @PathVariable String gender, Model model, @PathVariable("mail") String email,
			@PathVariable int age) {
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("gender", gender);
		model.addAttribute("age", age);
		model.addAttribute("method", "@PathVariable방식");
		return "member/info";
	}

	@RequestMapping("/joinDataObject")
	public String join(CustomerVO vo, Model model) {
//		model.addAttribute("name", vo.getName());
		model.addAttribute("vo", vo);
		model.addAttribute("method", "데이터객체");
		return "member/info";
	}

	@RequestMapping("/joinParam")
	public String join(@RequestParam String name, @RequestParam("gender") String g, String email, int age,
			Model model) {
		model.addAttribute("method", "@RequestParam");
		model.addAttribute("name", name);
		model.addAttribute("gender", g);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		return "member/info";
	}

	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest request, Model model) {
		// 전송된 파라미터 접근
		String name = request.getParameter("name");
		// String => int
		// int age = Integer.parseInt(request.getParameter("age"));
		int age = Integer.valueOf(request.getParameter("age"));
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("age", age);

		// 파라미터값을 정보화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("name", name);
		model.addAttribute("method", "HttpServletRequest 방식");
		return "member/info";
	}

	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}

	@RequestMapping("/third")
	public String third(Model model) {
		String dateTime = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date());
		model.addAttribute("dateTime", dateTime);
		return "now";
	}

	@RequestMapping("/second")
	public ModelAndView second() {
		// 비즈니스 로직
		SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분 ss초");
		String now = sdf.format(new Date());

		ModelAndView model = new ModelAndView();
		model.addObject("now", now);

		// 응답화면 지정
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/first")
	public String first(Model model) {
		// 비즈니스 로직
		String today = new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		model.addAttribute("today", today);
		// 응답화면 연결
		return "index";
	}
}
