package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveController {
	
	@GetMapping("/officeRtcanReserveList")
	public String rtcanReserveList() {
		return "reserve/officeRtcanReserveList.html";
	}
	@GetMapping("/officeRtcanReserveAdd")
	public String rtcanReserveAdd() {
		return "reserve/officeRtcanReserveAdd.html";
	}
	
	@GetMapping("/myReserve")
	public String myReserve() {
		return "reserve/myReserve";
	}
}
