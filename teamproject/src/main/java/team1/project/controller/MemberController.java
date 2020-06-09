package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/memberAdd")
	public String memberAdd() {
		return "member/memberAdd";
	}
}
