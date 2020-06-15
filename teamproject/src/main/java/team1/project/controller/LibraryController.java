package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.RegionService;
import team1.project.vo.Officer;
import team1.project.vo.Region;

@Controller
public class LibraryController {
	@Autowired private RegionService regionService;
	
	@PostMapping("/addRegion")
	public String addRegion(Region region, Officer officer) {
		System.out.println("========= addRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		int i = regionService.addRegion(region);
		System.out.println("실행결과" + i);
		return "library/officeRegion";
	}
	
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
