package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.LibraryService;
import team1.project.service.RegionService;
import team1.project.vo.Library;
import team1.project.vo.Officer;
import team1.project.vo.Region;

@Controller
public class LibraryController {
	@Autowired private RegionService regionService;
	@Autowired private LibraryService libraryService;
	
	@GetMapping(value="/getRegionMinorList")
	@ResponseBody
	public List<Region> getRegionMinorList(@RequestParam("regionMajor") String regionMajor) {
		System.out.println(regionMajor + "  <-getRegionMinorList LibraryController.java");
		System.out.println("========= getRegionMinorList LibraryController.java ============");
		List<Region> region = regionService.getRegionMinorList(regionMajor);
		System.out.println(region.toString());
		 
		return region;
	}
	
	@GetMapping("/getSearchRegion")
	public String getSearchRegion(Model model, @RequestParam(value="sk") String sk
									,@RequestParam(value="sv") String sv) {
		System.out.println("========= getSearchRegion LibraryController.java ============");
		System.out.println(sk +" <- sk;  " + sv + " <- sv;");
		List<Region> regionList = regionService.getSearchRegion(sk, sv);
		model.addAttribute("regionList", regionList);
		return "library/officeRegion";
	}
	
	@PostMapping("/deleteRegion")
	public String deleteRegion(Region region, Officer officer) {
		System.out.println("========= deleteRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		System.out.println(region.getOfficer().getOfficerId());
		System.out.println(region.getOfficer().getOfficerPw());
		int i = regionService.deleteRegion(region);
		System.out.println("deleteRegion 실행 결과 : "+i);
		return "redirect:/officeRegion";
	}
	
	@GetMapping(value="/selectRegion")
	@ResponseBody
	public Region getRegion(@RequestParam("regionCode") String regionCode) {
		System.out.println(regionCode + "  <-getRegion LibraryController.java");
		System.out.println("========= getRegion LibraryController.java ============");
		Region region = regionService.getRegion(regionCode);
		System.out.println(region.toString());
		 
		return region;
	}
	
	@PostMapping("/modifyRegion")
	public String modifyRegion(Region region, Officer officer) {
		System.out.println("========= addRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		int i = regionService.modifyRegion(region);
		System.out.println("modifyRegion 실행결과 : "+i);
		return "redirect:/officeRegion";
	}
	
	@PostMapping("/addRegion")
	public String addRegion(Region region, Officer officer) {
		System.out.println("========= addRegion LibraryController.java ============");
		region.setOfficer(officer);
		System.out.println(region.toString());
		int i = regionService.addRegion(region);
		System.out.println("실행결과  " + i);
		return "redirect:/officeRegion";
	}
	
	@GetMapping("/officeLibrary")
	public String getOfficeLibraryList(Model model) {
		System.out.println("==== 도서관 리스트 ===");
		List<Library> libraryList = libraryService.getLibraryList();
		System.out.println(libraryList);
		model.addAttribute("libraryList", libraryList);
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
