package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.PointService;
import team1.project.vo.Point;

@Controller
public class PointController {
	
	@Autowired private PointService pointService;
	
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
	public String getOfficePsList(Model model) {
		System.out.println("======== getOfficePsList PointController.java ========");
		List<Point> psList = pointService.getPsList();
		model.addAttribute("psList", psList);
		
		return "point/officePointStandard";
	}
	
	@GetMapping("/myPoint")
	public String myPoint() {
		return "point/myPoint";
	}
}
