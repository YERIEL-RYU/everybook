package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.RecommendService;

@Controller
public class RecommendController {
	
	private final static Logger logger = LoggerFactory.getLogger(RecommendController.class);
	@Autowired RecommendService recommendservice;
	
	@GetMapping("/vogueBookList")
	public String getVogueBookList() {
		return "recommend/vogueBookList";
	}
	
	@GetMapping("/recommendList")
	public String getRecommendList(HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("SID");
		String data = recommendservice.recommendList(memberId);
		model.addAttribute("data", data);
		return "recommend/recommendList";
	}
	

}
