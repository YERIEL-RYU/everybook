package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

	
	@GetMapping("/modifyReview")
	public String modifyReview() {
		return "review/modifyReview";
	}
	@GetMapping("/officeWarningList")
	public String officeWarningList() {
		return "review/officeWarningList";
	}
	
	@GetMapping("/officeModifyReview")
	public String officeModifyReview() {
		return "review/officeModifyReview";
	}
	
	@GetMapping("/officeReviewList")
	public String officeReviewList() {
		return "review/officeReviewList";
	}
	
	@GetMapping("/reviewList")
	public String reviewList(){
		return "review/reviewList";
	}
	
	//도서평등록화면(회원)
	@GetMapping("/addReview")
	public String addReview() {
		return "review/addReview";
	}
	
}
