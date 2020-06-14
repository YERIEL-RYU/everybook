package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendController {
	
	@GetMapping("/vogueBookList")
	public String getVogueBookList() {
		return "recommend/vogueBookList";
	}
	
	@GetMapping("/recommendList")
	public String getRecommendList() {
		return "recommend/recommendList";
	}
	

}
