package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.OfficerService;
import team1.project.vo.Officer;

@Controller
public class OfficerController {
	@Autowired OfficerService officerService;
	
	//직원리스트조회
	@GetMapping("/officerList")
	public String getOfficerList(Model model) {
		List<Officer> list = officerService.getOfficerList();
		System.out.println(list + " <- list");
		model.addAttribute("officerList", list);
		return "office/officerList";
	}
	
	//직원등록처리
	@PostMapping("/addOfficer")
	public String addOfficer(Officer officer, Model model) {
		System.out.println(officer);
		
		officerService.addOfficer(officer);
		return "redirect:/addOfficer";
	}
	
	@GetMapping("/addOfficer")
	public String addOfficer() {
		return "office/addOfficer";
	}
	
	//직원관리
	@GetMapping("/myOffice")
	public String myOffice() {
		
		return "office/myOffice";
	}
}
