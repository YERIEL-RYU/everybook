package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpandController {
	
	@GetMapping("/addExpand")
	public String addExpand() {
		
		return "expand/addExpand";
	}
}
