package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	@GetMapping("/bookDetail")
	public String bookDetail() {
		return "book/bookDetail";
	}

}
