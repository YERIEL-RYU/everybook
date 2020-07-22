package team1.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.BookService;
import team1.project.service.RecommendService;
import team1.project.service.RegionService;
import team1.project.vo.Book;
import team1.project.vo.Region;

@Controller
public class MainController {
	
	@Autowired	private RegionService regionService;
	@Autowired private RecommendService recommendService;
	@Autowired private BookService bookService;
	
	@GetMapping("/libraryTime")
	public String liberayTime() {
		return "information/libraryTime";
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
	public String index(Model model,HttpSession session) {
		String memberId = (String) session.getAttribute("SID");
		String libraryCode = (String) session.getAttribute("SLIBRARY");
		List<Region> majorList = regionService.getRegionMajorList();
		List<Region> regionList = regionService.getOfficeRegionList();
		List<String> bookIsbn = recommendService.recommendList(memberId);
		List<Book> recommondBook = new ArrayList<Book>();
		for(int i =0 ; i<10; i++) {
			List<Book> getBook = bookService.isbnSelectBook(bookIsbn.get(i), libraryCode);
			if(getBook != null) {
				recommondBook.addAll(getBook);
			}
		}
		model.addAttribute("majorList", majorList);
		model.addAttribute("regionList", regionList);
		model.addAttribute("recommondBook", recommondBook);
		return "index";
	}

}
