package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficerController {
	
	@GetMapping("/addOfficer")
	public String addOfficer() {
		return "office/addOfficer";
	}
	
	@GetMapping("/officerList")
	public String officerList() {
		
		return "office/officerList";
	}
	
	//직원관리 - 내 정보
	@GetMapping("/myOffice")
	public String myOffice() {
		
		return "office/myOffice";
	}
}
