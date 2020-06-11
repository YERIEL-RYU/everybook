package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {
	
	@GetMapping("/pointStandard")
	public String getPsList() {
		return "information/pointStandardList";
	}
	
	@GetMapping("/officePointHistoryList")
	public String getPhList() {
		return "point/officePointHistoryList";
	}
	
	@GetMapping("/officePointHistoryAdd")
	public String getOfficePhAdd() {
		return "point/officePointHistoryAdd";
	}
	
	@GetMapping("/officePointStandard")
	public String getOfficePsList() {
		return "point/officePointStandard";
	}
	
	@GetMapping("/myPoint")
	public String myPoint() {
		return "point/myPoint";
	}
}
