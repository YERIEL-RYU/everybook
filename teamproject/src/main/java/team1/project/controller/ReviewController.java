package team1.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.BookService;
import team1.project.vo.Book;

@Controller
public class ReviewController {

	@Autowired private BookService bookService;
	
	
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
	public String addReview(@RequestParam("send_code")String rentCode,Model model) {
		//Book bookName = bookService.getBookName(rentCode);
		//System.out.println("대여코드로 가져온 도서 이름 >>> "+bookName);
		//model.addAttribute("bookName", bookName);
		return "review/addReview";
	}
	
}
