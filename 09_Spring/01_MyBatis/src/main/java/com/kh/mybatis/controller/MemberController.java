package com.kh.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
   
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list", service.allMember());
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/mypage/register";
	}
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/mypage/login"; 	
	}
		
    @PostMapping("/login")
    public String login(Member vo, HttpServletRequest request) {
    	Member member = service.login(vo);
        HttpSession session = request.getSession();
        session.setAttribute("member", member);
    	return "redirect:/";
    }
		
    @PostMapping("/update")
    public String update(Member vo, HttpServletRequest request) {
    	HttpSession session = request.getSession(); 
    	Member member = (Member) session.getAttribute("member");
    	vo.setId(member.getId());
    	service.update(vo);
    	
    	Member result = service.login(vo);    	
    	session.setAttribute("member", result);
    	return "redirect:/";
    }
    
    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	Member member = (Member) session.getAttribute("member");
    	service.delete(member.getId());
    	session.invalidate();
    	return "redirect:/";
    }
    	
    
	@GetMapping("/search")
	public String search(SearchDTO dto, Model model) {
		model.addAttribute("list", service.search(dto));
		return "index";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam(name="idList", required = false) List<String> idList) {
		if(idList!= null) service.selectDelete(idList);
		return "redirect:/";
	}
		
	
    

}
