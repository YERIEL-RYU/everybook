package team1.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.vo.Book;
import team1.project.vo.Unicode;

@Controller
public class BookController {
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired private BookService bookService;
	
	@GetMapping("/addBookLibraryCode")
	@ResponseBody
	public Book addBookLibraryCode(@RequestParam("writer") String writer, @RequestParam("bookName") String bookName, HttpSession session) {
		List<Map<String, Character>> nameList = bookService.getCharList(writer);
		String secWrite = Unicode.codeNum(nameList);
		String reWriter = nameList.get(0).get("char").toString() + secWrite;
		String libraryCode = (String) session.getAttribute("SLIRARY");
		int num = bookService.sameNameCount(libraryCode, bookName, writer);
		Book book = new Book();
		book.setBookLibraryCode(reWriter);
		if(num != 0) {
			book.setReserveCount(num + 1);
		}
		
		return book;
	}
	
	/**
	 * 책등록에서 isbn으로 책 정보 조회하는 api 호출
	 * @param isbn
	 * @return Book isbnSearch
	 */
	@GetMapping("/searchIsbn")
	@ResponseBody
	public Book searchIsbn(@RequestParam("isbn") String isbn) {
		Book isbnSearch = bookService.searchIsbn(isbn);
		return isbnSearch;
	}
	
	@GetMapping("/bookDetail")
	public String bookDetail() {
		return "book/bookDetail";
	}
	@GetMapping("/bookList")
	public String bookList() {
		return "book/bookList";
	}
	@GetMapping("/officeAddbook")
	public String officeAddbook() {
		return "book/officeAddbook";
	}
	@GetMapping("/officeBooklist")
	public String officeBookList(Model model) {
		List<Book> list = bookService.officeBookList();
		logger.info("list : {}",list);
		model.addAttribute("officeBookList", list);
		return "book/officeBooklist";
	}
}
