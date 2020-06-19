package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.RentService;
import team1.project.vo.Member;
import team1.project.vo.Rent;

@Controller
public class RentController {
	@Autowired private RentService rentService;
	
	@GetMapping("/myRent")
		public String getRentHistoryList(Model model, HttpSession session, Rent rent) {

		String SID = (String) session.getAttribute("SID");
		System.out.println(SID + "<--SID");
		rent.setMemberId(SID);
		
		List<Rent> list = rentService.getRentHistoryList();
		System.out.println(list + " <-- list");
		model.addAttribute("rentHistory", list);
			
		return "rent/myRent";
	}
	
	@GetMapping("/officeBookRent")
	public String officeRent() {
		return "rent/officeBookRent";
	}
}
