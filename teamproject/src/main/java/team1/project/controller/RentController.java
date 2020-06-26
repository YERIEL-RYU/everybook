package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.RentService;
import team1.project.vo.Member;
import team1.project.vo.Rent;

@Controller
public class RentController {
	@Autowired private RentService rentService;
	
	@PostMapping("/officeRentDelete")
		public String officeRentDelete(Rent rent) {
		int i = rentService.officeRentDelete(rent);
		System.out.println(i + "<--실행결과");
		return "redirect:/officeBookRent";
	}
	
	@GetMapping(value="/selectRent")
	@ResponseBody
	public Rent getRent(@RequestParam("rentCode") String rentCode) {
		System.out.println(rentCode + " <-- getRent RentController.java");
		System.out.println("========= getRent RentController.java =======");
		Rent rent = rentService.getRent(rentCode);
		System.out.println(rent.toString());
		return rent;
	}
	
	@GetMapping("/myRent")
		public String myRentHistoryList(Model model, HttpSession session) {

		String SID = (String) session.getAttribute("SID"); //session 아이디값 받아오기.
		System.out.println(SID + "<--SID");

		
		List<Rent> list = rentService.myRentHistoryList(SID);
		System.out.println(list + " <-- list");
		model.addAttribute("rentHistory", list);

			
		return "rent/myRent";
	}
	
	@GetMapping("/officeBookRent")
	public String officeRentList(Model model) {
		List<Rent> list2 = rentService.officeRentList();
		System.out.println(list2 + " <-- list2");
		model.addAttribute("officeRentList", list2);
		
		return "rent/officeBookRent";
	}
}
