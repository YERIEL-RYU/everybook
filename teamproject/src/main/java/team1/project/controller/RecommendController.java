package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.RecommendService;

@Controller
public class RecommendController {
	
	@Autowired RecommendService recommendservice;
	
	@GetMapping("/vogueBookList")
	public String getVogueBookList() {
		return "recommend/vogueBookList";
	}
	
	@GetMapping("/recommendList")
	public String getRecommendList(HttpSession session) {
		String memberId = (String) session.getAttribute("SID");
		return "recommend/recommendList";
	}
	

}
