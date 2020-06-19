package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.LoginService;
import team1.project.vo.Login;
import team1.project.vo.Member;
import team1.project.vo.Officer;

@Controller
public class LoginController {
	
	@Autowired private LoginService loginService;
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/index";
	}
	
	@PostMapping("/loginOfficer")
	public String loginOfficer(Officer officer
								,HttpSession session) {
		
		System.out.println(officer.getOfficerId());
		System.out.println(officer.getOfficerPw());
				
		if(officer.getOfficerId() != null && !"".equals(officer.getOfficerId())
				&& officer.getOfficerPw() != null && !"".equals(officer.getOfficerPw())) {
			
			Officer o = loginService.getOfficerSelect(officer.getOfficerId());
			
			if(o !=null
					&& officer.getOfficerPw().equals(o.getOfficerPw())) {
				
				session.setAttribute("SID", o.getOfficerId());
				session.setAttribute("SLEVEL", o.getLevel());
				System.out.println(session.getAttribute("SID"));
				System.out.println(session.getAttribute("SLEVEL"));
				System.out.println("로그인완료");
				
				Login login = new Login();
				login.setOfficerId(o.getOfficerId());
				loginService.addLoginOfficer(login);
				
				return "admin/indexAdmin";
			}
		}
		return "redirect:/";
	}
	
	@PostMapping("/loginMember")
	public String loginMember(Member member
								,HttpSession session) {
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		
		if(member.getMemberId() != null && !"".equals(member.getMemberId())
				&& member.getMemberPw() != null && !"".equals(member.getMemberPw())) {
			
			Member m = loginService.getMemberSelect(member.getMemberId());
			
			if(m !=null
					&& member.getMemberPw().equals(m.getMemberPw())) {
				
				session.setAttribute("SID", m.getMemberId());
				session.setAttribute("SLEVEL", m.getLevelCode());
				System.out.println(session.getAttribute("SID"));
				System.out.println(session.getAttribute("SLEVEL"));
				System.out.println("로그인완료");
				
				Login login = new Login();
				login.setMemberId(m.getMemberId());
				System.out.println("log.getMemberId() >>>>"+login.getMemberId());
				loginService.addLoginMember(login);
			
				return "index";
			}
		}
		return "redirect:/";
	}
}
