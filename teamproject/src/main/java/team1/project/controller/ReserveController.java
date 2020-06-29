package team1.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.service.LibraryService;
import team1.project.service.MemberService;
import team1.project.vo.Book;
import team1.project.vo.Member;

@Controller

public class ReserveController {
	
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired MemberService memberSerive;
	@Autowired BookService bookService;
	
	@GetMapping("/reseve/getSelectBook")
	@ResponseBody
	public Book officeBookSerch(String bookName, String libraryCode) {
		Book book = bookService.officeBookSerch(bookName, libraryCode);
		logger.info("도서 상태 : {}",book.toString());
		
		return book;
	}
	
	@GetMapping("/reseve/getSelectMember")
	@ResponseBody
	public Member getSelectMember(String memberId) {
		Member member = memberSerive.selectgetMember(memberId);
		return member;
	}
	
	@GetMapping("/officeRtingReserveAdd")
	public String rtingReserveAdd() {
		return "reserve/officeRtingReserveAdd";
	}
	
	@GetMapping("/officeRtingReserveList")
	public String rtingReserveList() {
		return "reserve/officeRtingReserve";
	}
	
	
	@GetMapping("/officeRtcanReserveList")
	public String rtcanReserveList() {
		return "reserve/officeRtcanReserveList.html";
	}
	@GetMapping("/officeRtcanReserveAdd")
	public String rtcanReserveAdd() {
		return "reserve/officeRtcanReserveAdd.html";
	}
	
	@GetMapping("/myReserve")
	public String myReserve() {
		return "reserve/myReserve";
	}
}
