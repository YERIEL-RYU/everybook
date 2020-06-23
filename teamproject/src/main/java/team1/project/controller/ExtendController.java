package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.ExtendService;
import team1.project.vo.Rent;

@Controller
public class ExtendController {
	@Autowired private ExtendService extendService;
	
	@GetMapping("/officeBookextend")
	public String officeBookextend() {
		
		return "extend/officeBookextend";
	}
	
	@GetMapping("/addExtend")
	public String myRentList(Model model, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		System.out.println(SID + " <--SID");
		
		List<Rent> list = extendService.mtRengList(SID); 
		model.addAttribute("myRentList", list);
		return "extend/addExtend";
	}
}
