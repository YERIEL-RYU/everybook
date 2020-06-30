package team1.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.LibraryService;
import team1.project.service.MemberService;
import team1.project.service.RegionService;
import team1.project.vo.Library;
import team1.project.vo.Member;
import team1.project.vo.Region;

@Controller
public class MemberController {

	@Autowired private MemberService memberService;
	@Autowired private RegionService regionService;
	@Autowired private LibraryService libraryService;
	
	//회원 수정화면(직원)
	@GetMapping("/officeModifyMember")
	public String officeModifyMember(@RequestParam("send_id")String sendId, Model model) {
		System.out.println("href 받은 아이디 >>> "+sendId);
		
		
		model.addAttribute("sendId", sendId);
		return "member/officeModifyMember";
	}
	
	//회원 수정처리
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		System.out.println("수정된 정보 >> "+member.toString());
		
		memberService.ModifyMember(member);
		return "redirect:/index";
	}
	
	//회원 수정화면
	@GetMapping("/modifyMember")
	public String modifyMember(HttpSession session,Model model) {
		String name = (String) session.getAttribute("SID");
		String library = (String) session.getAttribute("SLIBRARY");
		Member member = memberService.DetailMember(name,library);
		System.out.println("상세보기화면 >>"+ member);
		
		//주소를 3개로 나눠서 출력
		Map<String, Object> address = memberService.getMemberAddress(name);
		
	
		model.addAttribute("member", member);
		model.addAttribute("address", address);
		model.addAttribute("regionMagjor", regionService.getRegionMajorList());
		return "member/modifyMember";
	}
	
	//회원 마이페이지(상세보기)
	@GetMapping("/memberDetail")
	public String memberDetail(HttpSession session,Model model) {
		String name = (String) session.getAttribute("SID");
		String library = (String) session.getAttribute("SLIBRARY");
		Member member = memberService.DetailMember(name,library);
		System.out.println("상세보기화면 >>"+ member);
		
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
	@GetMapping("/officeMemberDetail")
	public String officeMemberDetail() {
		return "member/officeMemberDetail";
	}
	
	//회원등록화면(직원)
	@GetMapping("/officeAddMember")
	public String officeAddMember(HttpSession session, Model model) {
		if(session.getAttribute("SID") != null && !"".equals(session.getAttribute("SID"))
				&& session.getAttribute("SLIBRARY") != null && !"".equals(session.getAttribute("SLIBRARY"))) {
			
			List<Region> regionMagjor = regionService.getRegionMajorList();
			model.addAttribute("regionMagjor", regionMagjor);
			
			return "member/officeAddMember";
		}
		return "login";
	}
	
	//회원리스트(직원)
	@GetMapping("/officeMemberList")
	public String officeMemberList(Model model) {
		
		model.addAttribute("memberList", memberService.allListMember());
		return "member/officeMemberList";
	}
	
	/*회원등록처리*/
	@PostMapping("/addMember")
	public String addMember(Member member) {
		System.out.println("addMember"+ member.toString());
		memberService.addMember(member);
		return "index";
	}
	
	//회원등록화면-입력된 아이디 중복 체크
	@GetMapping(value="/selectCheckMemberId")
	@ResponseBody
	public boolean selectCheckMemberId(@RequestParam("memberId") String memberId) {
		boolean result =memberService.selectCheckMemberId(memberId);
		System.out.println(result + "<---중복여부");
		return result;
	}
	
	/*회원등록화면-입력된 지역으로 지역도서관 화면출력 ajax*/
	@GetMapping(value="/selectLibraryCode")
	@ResponseBody
	public List<Library> selectLibraryCode(@RequestParam("region") List<String> region){
		//지역코드 출력
		System.out.println(region);
		String rMagjor = region.get(0);
		String rMinor = region.get(1);
		System.out.println(rMagjor);
		System.out.println(rMinor);
		
		String regionCode = regionService.selectRegionCode(rMagjor, rMinor);
		System.out.println(regionCode);
		
		//지역도서관 출력
		return libraryService.selectLibraryCode(regionCode);
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
