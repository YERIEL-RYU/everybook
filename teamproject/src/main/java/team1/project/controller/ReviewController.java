package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

	@GetMapping("officeReviewList")
	public String officeReviewList() {
		return "review/officeReviewList";
	}
	
	@GetMapping("reviewList")
	public String reviewList(){
		return "review/reviewList";
	}
	
	@GetMapping("addReview")
	public String addReview() {
		return "review/addReview";
	}
	
}
