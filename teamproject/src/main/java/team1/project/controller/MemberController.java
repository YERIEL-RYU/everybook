package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("officeMemberLogin")
	public String officeMemberLogin() {
		return "member/officeMemberLogin";
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
	
	@GetMapping("/addMember")
	public String memberAdd() {
		return "member/addMember";
	}
}
