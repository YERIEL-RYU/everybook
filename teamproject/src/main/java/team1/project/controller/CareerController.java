package team1.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CareerController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	
	//경력 등록화면
		@GetMapping("/addOfficerCareer")
		public String addOfficerCareer() {
			return "career/addOfficerCareer";
		}
}
