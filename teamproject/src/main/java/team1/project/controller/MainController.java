package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/office")
	public String admin() {
		return "admin/index_admin";
	}
	
	@GetMapping("/mylibrary")
	public String courses() {
		return "mylibrary/mylibrary";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
