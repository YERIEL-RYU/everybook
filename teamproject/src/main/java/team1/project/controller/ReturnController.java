package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.ReturnService;
import team1.project.vo.Return;

@Controller
public class ReturnController {
	@Autowired private ReturnService returnService;
	
	@GetMapping("/officeBookReturn")
	public String officeReturnList(Model model) {
		
		List<Return> list = returnService.officeReturnList();
		System.out.println(list + " <-- list");
		
		model.addAttribute("officeReturnList", list);
		
		return "return/officeBookReturn";
	}
}
