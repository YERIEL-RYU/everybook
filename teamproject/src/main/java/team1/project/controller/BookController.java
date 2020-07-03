package team1.project.controller;

import java.util.List;

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

@Controller
public class BookController {
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired private BookService bookService;
	
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
