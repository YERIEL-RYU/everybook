package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {
	
	@GetMapping("/officePointHistoryAdd")
	public String officePointHistoryAdd() {
		return "point/officePointHistoryAdd";
	}
	
	@GetMapping("/officePointStandard")
	public String officePointStandard() {
		return "point/officePointStandard";
	}
	
	@GetMapping("/myPoint")
	public String myPoint() {
		return "point/myPoint";
	}
}
