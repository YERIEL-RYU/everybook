package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {
	
	
		@GetMapping("/officeBudgetlist")
		public String officeBudget() {
			return "admin/officeBudgetlist";
		}

		@GetMapping("/officeAccountlist")
		public String officeAccountlist() {
			return "admin/officeAccountlist";
		}
		
		@GetMapping("/officeAddbudget")
		public String officeAddbudget() {
			return "admin/officeAddbudget";
		}
		
		@GetMapping("/officeAddaccount")
		public String officeAddaccount() {
			return "admin/officeAddaccount";
		}
}
