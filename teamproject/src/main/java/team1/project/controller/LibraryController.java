package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
	
	@GetMapping("/officeLibrary")
	public String getOfficeLibraryList() {
		return "library/officeLibrary";
	}
	
	@GetMapping("/officeRegion")
	public String getOfficeReionList() {
		return "library/officeRegion";
	}
}
