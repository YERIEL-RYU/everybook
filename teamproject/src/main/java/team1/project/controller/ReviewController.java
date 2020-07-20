package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.BookService;
import team1.project.service.ReviewService;
import team1.project.vo.Book;
import team1.project.vo.Review;

@Controller
public class ReviewController {

	@Autowired private BookService bookService;
	@Autowired private ReviewService reviewService;
	
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
	
	//도서평내역(회원)
	@GetMapping("/reviewList")
	public String reviewList(HttpSession session){
		String memberId =  (String)session.getAttribute("SID");
		
		List<Review> review = reviewService.selectReview(memberId);
		
		return "review/reviewList";
	}
	
	//도서평등록처리(회원)
	@PostMapping("/addReview")
	public String addReview(Review review,HttpSession session) {
		System.out.println("도서평등록화면에서 가져온 값 >>> "+review.toString());
		String memberId =  (String)session.getAttribute("SID");
		review.setMemberId(memberId);
		
		reviewService.addReview(review);
		return "redirect:/myRent";
	}
	
	//도서평등록화면(회원)
	@GetMapping("/addReview")
	public String addReview(@RequestParam("send_code")String rentCode,Model model) {
		Book bookName = bookService.getBookName(rentCode);
		System.out.println("대여코드로 가져온 도서 이름 >>> "+bookName);
		model.addAttribute("bookName", bookName);
		return "review/addReview";
	}
	
}
