package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {
	
		@GetMapping("/modifyBudget")
		public String modifyBudget() {
			return "admin/budget/modifyBudget";
		}
	
		@GetMapping("/modifyAccount")
		public String modifyAccount() {
			return "budget/modifyAccount";
		}
	
		@GetMapping("/listBudget")
		public String listBudget() {
			return "budget/listBudget";
		}

		@GetMapping("/listAccount")
		public String listAccount() {
			return "budget/listAccount";
		}
		
		@GetMapping("/addBudget")
		public String addBudget() {
			return "budget/addBudget";
		}
		
		@GetMapping("/addAccount")
		public String addAccount() {
			return "budget/addAccount";
		}
}
