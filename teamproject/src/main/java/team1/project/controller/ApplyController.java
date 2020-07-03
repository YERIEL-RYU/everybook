package team1.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import team1.project.service.ApplyService;
import team1.project.vo.Apply;

@Controller
public class ApplyController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private ApplyService applyService;
	
	//신청도서 등록!
	@PostMapping("/addBookApply")
	public String addBookApply(Apply apply) {
		logger.info("apply --> " + apply);
		 applyService.addBookApply(apply); 
		
		return "redirect:/myApply";
	}
	
	//나의 신청도서 신청취소
	@PostMapping("/deleteBookApply")
	public String deleteBookApply(Apply apply) {
		logger.info("deleteBookApply() apply --> " + apply);
		int i = applyService.deleteBookApply(apply);
		logger.info("실행결과-->" + i);
		return "redirect:/myApply"; 
	}
	
	//신청도서 신청취소 - (선택한 로우의 신청코드 받아오기)
		@GetMapping(value="/selectApply")
		@ResponseBody
		public Apply getApplyCode(@RequestParam(name = "applyCode") String applyCode) {
			logger.info("getRentCode() applyCode --> "+ applyCode);
			Apply apply = applyService.getApplyCode(applyCode);
			logger.info(applyCode);
			return apply;
		}
	
	//나의 신청도서 리스트
	@GetMapping("/myApply")
	public String myApplyList(Model model, HttpSession session) {
		
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " + SID);
				
		List<Apply> list = applyService.myApplyList(SID);				
		logger.info("list --> " + list);
		model.addAttribute("myApplyList", list);
		return "apply/myApply";
	}
	
	//희망도서 신청
	@GetMapping("/addBookApply")
	public String addBookApply() {
		return "apply/addBookApply";
	}
	
	//신청도서관리 - 신청도서리스트
	@GetMapping("/officeBookApply")
	public String officeApplyList(Model model) {
		List<Apply> list2 = applyService.officeApplyList();
		logger.info("list2 --> " + list2);
		model.addAttribute("officeApplyList", list2);
		return "apply/officeBookApply";
	}
}
