package team1.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.OverdueService;
import team1.project.vo.Overdue;

@Controller
public class OverdueController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private OverdueService overdueService;
	
	@GetMapping("/deleteOfficeOverdue")
	public String deleteOfficeOverdue(@RequestParam(name = "overdueCode") String overdueCode) {
		logger.info("overdueCode --> " + overdueCode);
		overdueService.deleteOfficeOverdue(overdueCode);
		
		return "redirect:/officeBookOverdue";
	}
	
	@GetMapping("/officeBookOverdue")
	public String officeOverdueList(Model model) {
		List<Overdue> list = overdueService.officeOverdueList();
		logger.info("list --> " + list);
		
		model.addAttribute("officeOverdueList", list);
		
		return "overdue/officeBookOverdue";
	}
}
