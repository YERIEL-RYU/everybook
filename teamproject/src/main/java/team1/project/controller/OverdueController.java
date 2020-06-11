package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverdueController {

	@GetMapping("/officeBookOverdue")
	public String officeBookOverdue() {
		return "overdue/officeBookOverdue";
	}
}
