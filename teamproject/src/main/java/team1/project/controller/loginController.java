package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {
	
	@PostMapping("loginMember")
	public String loginMember() {
		return "index";
	}
}
