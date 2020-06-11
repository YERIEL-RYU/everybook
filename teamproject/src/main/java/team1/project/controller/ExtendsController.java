package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExtendsController{
	@GetMapping("/officeBookextend")
	public String officeBookextend() {
		return "extend/officeBookextend";
	}
}
