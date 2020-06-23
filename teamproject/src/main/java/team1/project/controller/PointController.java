package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.PointService;
import team1.project.vo.Officer;
import team1.project.vo.Point;

@Controller
public class PointController {
	
	@Autowired private PointService pointService;
	
	@PostMapping("/addPs")
	public String addPs(Point point, Officer officer) {
		System.out.println("===== 상벌점 기준 등록 =====");
		point.setOfficer(officer);
		System.out.println(point.toString() +" <- point.java pointController.java");
		int i = pointService.addPs(point);
		System.out.println("실행 결과 : " + i);
		return "redirect:/officePointStandard";
	}
	
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
