package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.service.MemberService;
import team1.project.service.RtcanReserveService;
import team1.project.vo.Book;
import team1.project.vo.Member;
import team1.project.vo.RtcanReserve;

@Controller

public class ReserveController {
	
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired MemberService memberSerive;
	@Autowired BookService bookService;
	@Autowired RtcanReserveService rtcanReserveService;
	
	//직원 화면 : 오프라인 예약을 위한 책 코드 조회
	@GetMapping("/reserve/getSelectBook")
	@ResponseBody
	public Book officeBookSerch(String bookLibraryCode, String libraryCode) {
		logger.info("bookname : {}", bookLibraryCode);
		logger.info("libraryCode : {}", libraryCode);
		Book book = bookService.officeBookSerch(bookLibraryCode, libraryCode);
		logger.info("book : {}",book);
		return book;
	}
	 
	//직원화면 : 오프라인 예약을 위한 책제목 조회
	@GetMapping("/reserve/bookSearch")
	@ResponseBody
	public List<Book> getSelectBook(String bookName, String libraryCode) {
		logger.info("bookname : {}", bookName);
		logger.info("libraryCode : {}", libraryCode);
		List<Book> book = bookService.officeBookSerchList(bookName, libraryCode);
		return book;
	}
	
	//직원 화면 : 오프라인 예약을 위한 회원 조회
	@GetMapping("/reseve/getSelectMember")
	@ResponseBody
	public Member getSelectMember(String memberId) {
		Member member = memberSerive.selectgetMember(memberId);
		return member;
	}
	
	//직원 화면 : 오프라인 예약 등록 화면 
	@GetMapping("/officeRtingReserveAdd")
	public String rtingReserveAdd() {
		return "reserve/officeRtingReserveAdd";
	}
	
	//직원 화면 :  등록 된 오프라인 예약 리스트
	@GetMapping("/officeRtingReserveList")
	public String rtingReserveList() {
		return "reserve/officeRtingReserve";
	}
	
	//직원 화면 : 등록된 온라인 예약 리스트
	@GetMapping("/officeRtcanReserveList")
	public String rtcanReserveList() {
		return "reserve/officeRtcanReserveList";
	}
	
	//직원 화면 : 회원이 등록한 책 예약 확인 후 직원이 승인하기 위한 페이지 출력
	@GetMapping("/officeRtcanReserveAdd")
	public String officeRtcanReserveAdd(Model model, HttpSession session) {
		String libraryCode = (String) session. getAttribute("SLIBRARY");
		logger.info("session 값 : {}",libraryCode);
		List<RtcanReserve> rtcanReserveList = rtcanReserveService.addReserve(libraryCode);
		model.addAttribute("rtcanReserveList", rtcanReserveList);
		return "reserve/officeRtcanReserveAdd";
	}
	
	//회원화면 : 온라인 예약 등록 insert
	@PostMapping("/rtcanReserveAdd")
	public String rtcanReserveAdd(RtcanReserve rtcanReserve) {
		logger.info("온라인 예약 임둥 : {}",rtcanReserve.toString());
		int i = rtcanReserveService.addRtcanReserve(rtcanReserve);
		logger.info("실행경과 : {}", i);
		return "book/bookDetail";
	}
	
	//회원 화면 : 회원 예약 리스트 출력
	@GetMapping("/myReserve")
	public String myReserve() {
		return "reserve/myReserve";
	}
}
