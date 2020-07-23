package team1.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.WarningService;
import team1.project.vo.Warning;

@Controller
public class WarningController {
	
	@Autowired WarningService warningService;
	
	//도서평 신고 등록처리
	@PostMapping("/addWarning")
	public String addWarning(Warning warning) {

		warningService.addWarning(warning);
		return "redirect:/bookList";
	}
	
}
