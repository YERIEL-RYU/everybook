package team1.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.RegionService;

@Controller
public class LibraryController {
	@Autowired private RegionService regionService;
	
	@GetMapping("/officeLibrary")
	public String getOfficeLibraryList() {
		return "library/officeLibrary";
	}
	
	@GetMapping("/officeRegion")
	public String getOfficeReionList() {
		
		return "library/officeRegion";
	}
}
