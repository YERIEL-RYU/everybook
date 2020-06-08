package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveController {
	
	@GetMapping("/myReserve")
	public String myReserve() {
		return "reserve/reserve";
	}
}
