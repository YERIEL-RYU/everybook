package team1.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.LibraryService;
import team1.project.service.RegionService;
import team1.project.vo.Region;

@Controller
public class MainController {
	
	@Autowired	private RegionService regionService;
	@Autowired	private LibraryService libraryService;
	
	@GetMapping("/libraryTime")
	public String liberayTime() {
		return "information/libraryTime";
	}
	

	@GetMapping("/libraryList")
	public String getLibraryList(Model model,@RequestParam(value="currentPage", 
			  									required=false, defaultValue="1") int currentPage) {
		Map<String, Object> returnMap = libraryService.getLimitLibraryList(currentPage);
		model.addAttribute("list", returnMap.get("list"));
    	model.addAttribute("currentPage",returnMap.get("currentPage"));
    	model.addAttribute("lastPage",returnMap.get("lastPage"));
    	model.addAttribute("startPageNum",returnMap.get("startPageNum"));
    	model.addAttribute("lastPageNum", returnMap.get("lastPageNum"));
		return "information/libraryList";
	}	

	@GetMapping("/")
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
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Region> majorList = regionService.getRegionMajorList();
		List<Region> regionList = regionService.getOfficeRegionList();
		model.addAttribute("majorList", majorList);
		model.addAttribute("regionList", regionList);
		return "index";
	}

}
