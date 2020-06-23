package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.PointService;
import team1.project.vo.Officer;
import team1.project.vo.Point;

@Controller
public class PointController {
	
	@Autowired private PointService pointService;
	
	@PostMapping("/deletePs")
	public String deletePs(Point point, Officer officer) {
		System.out.println("==== 상벌점 기준 삭제 컨트롤러 ====");
		point.setOfficer(officer);
		System.out.println(point.toString() +" deletePs PointController.java");
		int i = pointService.deletePs(point);
		System.out.println("실행결과 : " + i);
		return "redirect:/officePointStandard";
	}
	
	@PostMapping("/modifyPs")
	public String modifyPs(Point point, Officer officer) {
		System.out.println("==== 상벌점 기준 수정 컨트롤러 ====");
		point.setOfficer(officer);
		System.out.println(point.toString() +" modifyPs PointController.java");
		int i = pointService.modifyPs(point);
		System.out.println("실행결과 : " + i);
		return "redirect:/officePointStandard";
	}
	
	@GetMapping("/getSelectPs")
	@ResponseBody
	public Point getSelectPs(@RequestParam("psCode") String psCode) {
		System.out.println(psCode + " <- psCode pointController.java");
		Point point = pointService.getSelectPs(psCode);
		return point;
	}
	
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
