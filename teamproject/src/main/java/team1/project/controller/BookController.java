package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
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
		return "admin/officeAddbook";
	}
	@GetMapping("/officeBooklist")
	public String officeBooklist() {
		return "admin/officeBooklist";
	}
}
