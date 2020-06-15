package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturnController {

	@GetMapping("/officeBookReturn")
	public String officeBookReturn() {
		return "return/officeBookReturn";
	}
}
