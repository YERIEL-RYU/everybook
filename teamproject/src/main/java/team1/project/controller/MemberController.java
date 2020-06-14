package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@GetMapping("officeModifyMember")
	public String officeModifyMember() {
		return "member/officeModifyMember";
	}
	
	@PostMapping("modifyMember")
	public String modifyMember() {
		return "member/modifyMember";
	}
	
	@GetMapping("memberDetail")
	public String memberDetail() {
		return "member/memberDetail";
	}
	
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
