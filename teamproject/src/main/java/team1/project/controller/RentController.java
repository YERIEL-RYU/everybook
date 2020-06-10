package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentController {

	@GetMapping("/officeBookRent")
	public String officeRent() {
		return "rent/officeBookRent";
	}
}
