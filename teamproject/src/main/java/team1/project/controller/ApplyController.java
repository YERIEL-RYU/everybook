package team1.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.ApplyService;
import team1.project.vo.Apply;

@Controller
public class ApplyController {
	@Autowired private ApplyService applyService;
	
	//신청도서 등록!
	@PostMapping("/addBookApply")
	public String addBookApply(Apply apply, @RequestParam(name = "apDate", required = false) String apDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = format.parse(apDate); //String타입을 Date타입으로 변환
		apply.setApplyPublishDate(date); // vo에 셋팅
		System.out.println(apply);
		
		applyService.addBookApply(apply);
		
		return "redirect:/myApply";
	}
	//나의 신청도서 리스트
	@GetMapping("/myApply")
	public String myApplyList(Model model, HttpSession session) {
		
		String SID = (String) session.getAttribute("SID");
		System.out.println(SID + " <--SID");
				
		List<Apply> list = applyService.myApplyList(SID);				
		System.out.println(list + " <-- List");
		model.addAttribute("myApplyList", list);
		return "apply/myApply";
	}
	
	@GetMapping("/addBookApply")
	public String addBookApply() {
		return "apply/addBookApply";
	}
	//신청도서관리 - 신청도서리스트
	@GetMapping("/officeBookApply")
	public String officeApplyList(Model model) {
		List<Apply> list2 = applyService.officeApplyList();
		System.out.println(list2 + " <- list2");
		
		model.addAttribute("officeApplyList", list2);
		return "apply/officeBookApply";
	}
}
