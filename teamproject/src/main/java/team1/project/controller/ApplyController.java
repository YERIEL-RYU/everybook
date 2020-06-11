package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplyController {

	@GetMapping("/officeBookApply")
	public String officeBookApply() {
		return "apply/officeBookApply";
	}
}
