package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendController {
	
	@GetMapping("/recommendList")
	public String getRecommendList() {
		return "recommend/recommendList";
	}
	

}
