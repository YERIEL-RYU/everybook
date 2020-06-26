package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.BookService;
import team1.project.vo.Book;

@Controller
public class BookController {
	@Autowired private BookService bookService;
	
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
		System.out.println(list + " <-- list");
		model.addAttribute("officeBookList", list);
		return "book/officeBooklist";
	}
}
