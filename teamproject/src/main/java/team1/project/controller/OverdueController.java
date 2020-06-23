package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.OverdueService;
import team1.project.vo.Overdue;

@Controller
public class OverdueController {
	@Autowired private OverdueService overdueService;
	
	@GetMapping("/officeBookOverdue")
	public String officeOverdueList(Model model) {
		List<Overdue> list = overdueService.officeOverdueList();
		System.out.println(list + " <-- list");
		
		model.addAttribute("officeOverdueList", list);
		
		return "overdue/officeBookOverdue";
	}
}
