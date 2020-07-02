package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private RentService rentService;
	
	//대여관리 - 대여리스트 삭제처리
	@PostMapping("/officeRentDelete")
		public String officeRentDelete(Rent rent) {
		int i = rentService.officeRentDelete(rent);
		logger.info("실행결과 --> " + i);
		return "redirect:/officeBookRent";
	}
	
	//대여관리 -대여리스트 삭제(선택한 로우의 대여코드 받아오기)
	@GetMapping(value="/selectRent")
	@ResponseBody
	public Rent getRent(@RequestParam("rentCode") String rentCode) {
		logger.info(rentCode + " <-- getRent RentController.java");
		logger.info("========= getRent RentController.java =======");
		Rent rent = rentService.getRent(rentCode);
		logger.info(rent.toString());

		return rent;
	}
	
	@GetMapping("/myRent")
		public String myRentHistoryList(Model model, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " +SID);

		List<Rent> list = rentService.myRentHistoryList(SID);
		logger.info("list --> " +list);
		model.addAttribute("rentHistory", list);
			
		return "rent/myRent";
	}
	//대여관리 - 대여리스트 검색
	@GetMapping("/OfficeRentListSerch")
	public String OfficeRentListSerch(Model model,
						@RequestParam(name = "sk") String sk,
						@RequestParam(name = "sv") String sv) {
		logger.info("sk : " + sk + " sv : " + sv);
		List<Rent> officeRentList = rentService.OfficeRentListSerch(sk, sv);
		model.addAttribute("officeRentList", officeRentList);
		
		return "rent/officeBookRent";
	}
	
	//대여관리 - 대여리스트
	@GetMapping("/officeBookRent")
	public String officeRentList(Model model) {
		List<Rent> officeRentList = rentService.officeRentList();
		logger.info("officeRentList --> " +officeRentList);
		model.addAttribute("officeRentList", officeRentList);
		
		return "rent/officeBookRent";
	}
}
