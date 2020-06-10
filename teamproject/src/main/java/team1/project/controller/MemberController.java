package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/officeMemberList")
	public String officeMemberList() {
		return "member/officeMemberList";
	}
	
	@GetMapping("/addMember")
	public String memberAdd() {
		return "member/addMember";
	}
}
