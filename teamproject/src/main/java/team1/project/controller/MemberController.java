package team1.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.MemberService;
import team1.project.service.RegionService;
import team1.project.vo.Member;
import team1.project.vo.Region;

@Controller
public class MemberController {

	@Autowired private MemberService memberService;
	@Autowired private RegionService regionService;
	
	@GetMapping("/officeModifyMember")
	public String officeModifyMember() {
		return "member/officeModifyMember";
	}
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		System.out.println("수정된 정보 >> "+member.toString());
		
		memberService.ModifyMember(member);
		return "redirect:/index";
	}
	
	@GetMapping("/modifyMember")
	public String modifyMember(HttpSession session,Model model) {
		String name = (String) session.getAttribute("SID");
		Member m = memberService.selectgetMember(name);
		Member member = memberService.DetailMember(m);
		System.out.println("상세보기화면 >>"+ member);
		
		model.addAttribute("member", member);
		
		return "member/modifyMember";
	}
	
	@GetMapping("/memberDetail")
	public String memberDetail(HttpSession session,Model model) {
		String name = (String) session.getAttribute("SID");
		Member m = memberService.selectgetMember(name);
		Member member = memberService.DetailMember(m);
		System.out.println("상세보기화면 >>"+ member);
		
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
	@GetMapping("/officeMemberDetail")
	public String officeMemberDetail() {
		return "member/officeMemberDetail";
	}
	
	@GetMapping("/officeAddMember")
	public String officeAddMember() {
		return "member/officeAddMember";
	}
	
	@GetMapping("/officeMemberList")
	public String officeMemberList(Model model) {
		List<Member> memberList = new ArrayList<Member>();
		memberService.allListMember();
		
		return "member/officeMemberList";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		System.out.println("addMember"+ member.toString());
		memberService.addMember(member);
		return "index";
	}

	/*회원등록화면-지역소분류(시)출력위한 ajax*/
	@GetMapping(value="/selectRegionMinor")
	@ResponseBody
	public List<Region> selectRegionMinor(@RequestParam("regionMagjor") String regionMagjor) {
		System.out.println("선택한 지역대분류(도) >>>"+regionMagjor);
		return regionService.getRegionMinorList(regionMagjor);
	}
	
	/*회원등록화면*/
	@GetMapping("/addMember")
	public String memberAdd(Model model) {
		List<Region> regionMagjor = regionService.getRegionMajorList();
		model.addAttribute("regionMagjor", regionMagjor);
		return "member/addMember";
	}
}
