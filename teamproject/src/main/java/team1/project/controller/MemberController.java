package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.MemberService;
import team1.project.vo.Member;

@Controller
public class MemberController {

	@Autowired private MemberService memberService;
	
	
	@GetMapping("/officeModifyMember")
	public String officeModifyMember() {
		return "member/officeModifyMember";
	}
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		System.out.println("수정된 정보 >> "+member.toString());
		
		memberService.ModifyMember(member);
		return "redirect:/index";
	}
	
	@GetMapping("/modifyMember")
	public String modifyMember(HttpSession session,Model model) {
		String name = (String) session.getAttribute("SID");
		Member m = memberService.selectgetMember(name);
		Member member = memberService.DetailMember(m);
		System.out.println("상세보기화면 >>"+ member);
		
		model.addAttribute("member", member);
		
		return "member/modifyMember";
	}
	
	@GetMapping("/memberDetail")
	public String memberDetail(HttpSession session,Model model) {
		String name = (String) session.getAttribute("SID");
		Member m = memberService.selectgetMember(name);
		Member member = memberService.DetailMember(m);
		System.out.println("상세보기화면 >>"+ member);
		
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
	@GetMapping("/officeMemberDetail")
	public String officeMemberDetail() {
		return "member/officeMemberDetail";
	}
	
	@GetMapping("/officeAddMember")
	public String officeAddMember() {
		return "member/officeAddMember";
	}
	
	@GetMapping("/officeMemberList")
	public String officeMemberList() {
		return "member/officeMemberList";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		System.out.println("addMember"+ member.toString());
		memberService.addMember(member);
		return "index";
	}
	
	@GetMapping("/addMember")
	public String memberAdd() {
		return "member/addMember";
	}
}
