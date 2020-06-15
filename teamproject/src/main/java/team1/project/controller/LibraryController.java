package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.RegionService;
import team1.project.vo.Region;

@Controller
public class LibraryController {
	@Autowired private RegionService regionService;
	
	@GetMapping("/officeLibrary")
	public String getOfficeLibraryList() {
		return "library/officeLibrary";
	}
	
	@GetMapping("/officeRegion")
	public String getOfficeRegionList(Model model) {
		System.out.println("========= getOfficeRegionList LibraryController.java ============");
		List<Region> regionList = regionService.getOfficeRegionList();
		List<Region> regionMajorList = regionService.getRegionMajorList();
		model.addAttribute("regionList", regionList);
		model.addAttribute("regionMajorList", regionMajorList);
		return "library/officeRegion";
	}
}
