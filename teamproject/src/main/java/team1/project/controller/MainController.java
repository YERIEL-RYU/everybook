package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/libraryTime")
	public String liberayTime() {
		return "information/libraryTime";
	}
	

	@GetMapping("/libraryList")
	public String getLibraryList() {
		return "information/libraryList";
	}	

	@GetMapping("/login")
	public String login() {
		return "login";

	}
	
	@GetMapping("/office")
	public String office() {
		return "admin/indexAdmin";
	}
	
	@GetMapping("/myLibrary")
	public String myLibrary() {
		return "information/myLibrary";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
