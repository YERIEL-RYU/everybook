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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.service.MemberService;
import team1.project.service.ReturnService;
import team1.project.vo.Book;
import team1.project.vo.Member;
import team1.project.vo.Return;

@Controller
public class ReturnController {
	private final static Logger logger = LoggerFactory.getLogger(ReturnController.class);
	@Autowired private ReturnService returnService;
	@Autowired private MemberService memberService;
	@Autowired private BookService bookService;
	
	//반납처리
	@PostMapping("addBookReturn")
	public String addBookReturn(Return returnVo, HttpSession session) {
		logger.info("======== addBookReturn ReturnController.java ========");
		String Sid = (String) session.getAttribute("SID");
		returnVo.setOfficerId(Sid);
		logger.info("반납처리 --> " + returnVo);
		returnService.addBookReturn(returnVo);
		return "return/officeBookReturn";
	}
	
	//청구기호로 검색시 도서 정보 검색하여 화면에 출력
		@GetMapping("/return/getSelectBook")
		@ResponseBody
		public Book getSelectBook(String bookLibraryCode, HttpSession session) {
			logger.info("======== getSelectBook ReturnController.java ========");
			String libraryCode = (String)session.getAttribute("SLIBRARY");
			logger.info("SLIBRARY --> " + libraryCode);
			Book book = bookService.officeBookSerch(bookLibraryCode, libraryCode);
			logger.info("book -> " + book);
			
			return book;
		}
	
	//회원 아이디로 검색시 회원 정보 검색하여 화면에 출력
		@GetMapping("/return/getSelectMember")
		@ResponseBody
		public Member getSelectMember(String memberId) {
			logger.info("======== getSelectMember ReturnController.java ========");
			Member member = memberService.selectgetMember(memberId);
			logger.info("member -> " + member);
			return member;
		}
	
	//반납관리 - 반납도서리스트 검색
	@GetMapping("/officeReturnListSearch")
	public String officeReturnListSearch(Model model,
					@RequestParam(name = "sk") String sk,
					@RequestParam(name = "sv") String sv) {
		logger.info("======== officeReturnListSearch ReturnController.java ========");
		logger.info("sk : " + sk + " sv : " + sv);
		List<Return> officeReturnList = returnService.officeReturnListSearch(sk, sv);
		model.addAttribute("officeReturnList", officeReturnList);
		
		return "return/officeBookReturn";
	}
	
	//반납관리 - 반납도서리스트 조회
	@GetMapping("/officeBookReturn")
	public String officeReturnList(Model model) {
		logger.info("======== officeReturnList ReturnController.java ========");
		List<Return> officeReturnList = returnService.officeReturnList();
		System.out.println(officeReturnList + " <-- officeReturnList");
		model.addAttribute("officeReturnList", officeReturnList);
		
		return "return/officeBookReturn";
	}
}
