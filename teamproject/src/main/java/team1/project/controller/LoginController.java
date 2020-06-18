package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team1.project.service.LoginService;
import team1.project.vo.Member;

@Controller
public class LoginController {
	
	@Autowired private LoginService loginService;
	
	@PostMapping("loginMember")
	public String loginMember(Member member
								,HttpSession session
								,RedirectAttributes redirectAttr) {
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		
		if(member.getMemberId() != null && !"".equals(member.getMemberId())
				&& member.getMemberPw() != null && !"".equals(member.getMemberPw())) {
			
			Member m = loginService.getMemberSelect(member.getMemberId());
			
			if(m !=null
					&& member.getMemberPw().equals(m.getMemberPw())) {
				
				session.setAttribute("SID", m.getMemberId());
				session.setAttribute("SNAME", m.getMemberName());
				session.setAttribute("SLEVEL", m.getLevelCode());
				System.out.println(session.getAttribute("SID"));
				System.out.println(session.getAttribute("SNAME"));
				System.out.println(session.getAttribute("SLEVEL"));
				System.out.println("로그인완료");
			
				return "redirect:/";
			}
		}
		redirectAttr.addAttribute("message", "등록된 정보가 없습니다.");
		return "index";
	}
}
