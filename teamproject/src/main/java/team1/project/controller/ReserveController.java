package team1.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.MemberService;
import team1.project.vo.Member;

@Controller

public class ReserveController {
	
	@Autowired MemberService memberSerive;
	
	@GetMapping("/reseve/getSelectMember")
	@ResponseBody
	public Member getSelectMember(String memberId) {
		Member member = memberSerive.selectgetMember(memberId);
		return member;
	}
	
	@GetMapping("/officeRtingReserveAdd")
	public String rtingReserveAdd() {
		return "reserve/officeRtingReserveAdd";
	}
	
	@GetMapping("/officeRtingReserveList")
	public String rtingReserveList() {
		return "reserve/officeRtingReserve";
	}
	
	
	@GetMapping("/officeRtcanReserveList")
	public String rtcanReserveList() {
		return "reserve/officeRtcanReserveList.html";
	}
	@GetMapping("/officeRtcanReserveAdd")
	public String rtcanReserveAdd() {
		return "reserve/officeRtcanReserveAdd.html";
	}
	
	@GetMapping("/myReserve")
	public String myReserve() {
		return "reserve/myReserve";
	}
}
