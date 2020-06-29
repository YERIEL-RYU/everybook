package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.LibraryService;
import team1.project.service.OfficerService;
import team1.project.vo.Library;
import team1.project.vo.Officer;

@Controller
public class OfficerController {
	@Autowired OfficerService officerService;
	@Autowired LibraryService libraryService;
	
	//나의정보 수정화면
	@GetMapping("/myOfficeModify")
	public String myOfficeModify(Officer officer, Model model ) {
		System.out.println("ㅡㅡㅡㅡㅡmyOfficeModify() OfficerController.javaㅡㅡㅡㅡㅡ");
		System.out.println(officer.toString());		
		  
		  List<Officer> officerList = officerService.getMyOffice(officer.getOfficerId());
		  System.out.println(officerList + "<-- officerList");
		  model.addAttribute("officerList", officerList.get(0));
		 
		
		return "office/myOfficeModify";
	}
	
	//도서관이름으로 코드검색
	@PostMapping(value="/libraryCodeSearch")
	@ResponseBody
	public Library getLibraryCodeSearch(@RequestParam("libraryNameSk") String libraryNameSk) {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡOfficerController.javaㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(libraryNameSk + " <-- libraryNameSk OfficerController.java");
		Library library = libraryService.getLibraryCodeSearch(libraryNameSk);
		return library;
	}
	
	//나의정보조회
	@GetMapping("/myOffice")
	public String getMyOffice(Model model, HttpSession session) {
		System.out.println("ㅡㅡㅡㅡㅡ<-- getMyOffice() OfficerController.javaㅡㅡㅡㅡㅡ");
		String SID = (String) session.getAttribute("SID");
		System.out.println(SID + " <-- SID");
		
		List<Officer> list2 = officerService.getMyOffice(SID);
		System.out.println(list2 + " <--list2");
		model.addAttribute("getMyOffice", list2.get(0));
		
		return "office/myOffice";		
	}
	
	//직원리스트조회
	@GetMapping("/officerList")
	public String getOfficerList(Model model) {
		List<Officer> list = officerService.getOfficerList();
		System.out.println(list + " <- list");
		model.addAttribute("officerList", list);
		return "office/officerList";
	}
	
	//직원등록처리
	@PostMapping("/addOfficer")
	public String addOfficer(Officer officer) {
		System.out.println(officer);
		officerService.addOfficer(officer);
		return "redirect:/addOfficer";
	}
	
	//직원등록화면
	@GetMapping("/addOfficer")
	public String addOfficer(Model model) {
		Officer officer = officerService.getOfficerId();
		System.out.println(officer + " <-- officer OfficerController.java");
		model.addAttribute("officerId", officer);
		return "office/addOfficer";
	}
}
